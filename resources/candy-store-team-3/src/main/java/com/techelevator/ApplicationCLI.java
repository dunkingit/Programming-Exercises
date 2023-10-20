package com.techelevator;
import com.techelevator.Accounts.CustomerAccount;
import com.techelevator.Accounts.VenderAccount;
import com.techelevator.Inventory.ManagesInventory;
import com.techelevator.StoreProps.Cart;
import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.CartItem;
import com.techelevator.items.Item;
import com.techelevator.random.RandomGen;
import com.techelevator.StoreProps.Register;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.view.Menu;
import com.techelevator.view.UserInput;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;


public class ApplicationCLI {
    String userFile;
    LogFileWriter logger = new LogFileWriter();
    Menu menu = new Menu();
    UserInput ui = new UserInput();
    InventoryFileReader storeClerkReads = new InventoryFileReader(logger);
    ManagesInventory storeClerkManagesInventory = new ManagesInventory(menu, logger);
    CustomerAccount customerAccount = new CustomerAccount(logger);
    VenderAccount venderaccount = new VenderAccount(logger);
    Cart cart = new Cart(logger, menu);
    Register register = new Register(customerAccount, venderaccount, ui, cart, logger);

    public static void main(String[] args) {
        ApplicationCLI cli = new ApplicationCLI();
        cli.run();
        cli.MainMenu();
    }

    public String innerFileMenu() {
        while (true) {
            String userSelectFileChoice = ui.displayMenuOptions(Text.ENTER_FILE_CHOICES, Text.IOFILENAME);
            logger.writedev("Choice: " + userSelectFileChoice);
            if (userSelectFileChoice.equals("1")) {
                if (storeClerkReads.checkForFile(ui)) {
                    logger.writedev("File: " + userFile);
                    userFile = userSelectFileChoice;
                    return "1";
                }
            }
            if (userSelectFileChoice.equals("2")) {
                return "2";
            }
            if (userSelectFileChoice.equals("3")) {
                return "";
            }
        }
    }

    public void run() {

        List<String[]> stringlists;

        while (true) {
            String choice = ui.displayMenuOptions(Text.FILE_CHOICE, ui.getRandomChoice(5));
            logger.writedev("Choice: " + choice);

            if (choice.equals("1")) {

                String option = innerFileMenu();
                if(option.equals("1")) {
                    stringlists = storeClerkReads.readFromFileIntoInventory(storeClerkReads.getFileObj());
                    break;
                }
                if(option.equals("2")) {
                    stringlists = storeClerkReads.stocksAllInventoryFromDefault("inventory.csv");
                    break;
                }
            }
            if (choice.equals("2")) {
                List<String> temp = storeClerkReads.stocksAllWithRandomInventory("Random.csv");
                RandomGen rg = new RandomGen(100, temp);
                rg.generateRandomItemsFullAuto();
                stringlists = rg.getListsOfItemsAsStrings();
                break;
            }
            if (choice.equals("3")) {
                stringlists = storeClerkReads.stocksAllInventoryFromDefault("inventory.csv");
                break;
            }
        }

        storeClerkManagesInventory.iterStringListsPlaceIntoInventory(stringlists);
        menu.displayMessage(menu.displayBox());
    }


    public void MainMenu(){
        while(true) {
            String choice = ui.displayMenuOptions(Text.CHOICE_MAIN, ui.getRandomChoice(5));
            logger.writedev("Choice: " + choice);
            if (choice.equals("1")) {
                storeClerkManagesInventory.printInventory();
                ui.printRandomChoice(0);
            }
            if (choice.equals("2")) {
                processSubMenu();
            }
            if (choice.equals("3")) {
                System.exit(0);
            }
        }
    }

    private void processSubMenu() {
        while (true) {
            menu.printBalance(customerAccount);
            String subChoice = ui.displayMenuOptions(Text.CHOICE_SECOND, ui.getRandomChoice(5));;
            logger.writedev("subChoice: " + subChoice);
            if ("1".equals(subChoice)) {
                int inputMoney = ui.inputGetInt(ui.getRandomChoice(8));
                int amountCheck = register.insertMoneyOption(inputMoney);
                customerAccount.deposit(amountCheck);
            } else if ("2".equals(subChoice)) {
                selectItems();
            } else if ("3".equals(subChoice)) {
                if (customerAccount.getBalance() <= 0 || cart.getQuantityInCart() <= 0){
                    menu.displayMessage("You can not check out at this time. " +
                            "Please add something to yoru cart and add money to your balance.");
                    continue;
                }
                cart.cartStatus();
                boolean checkedOut = register.checkout();
                if(checkedOut){
                    cart.getShoppingCart().clear();
                    logger.writeTransactions("SUCCESSFUL CHECKOUT: ", 0, 0);
                    logger.writedev("SUCCESSFUL CHECKOUT: ");
                }

            } else if ("4".equals(subChoice)) {
                return;  // Break out of the while loop
            }
        }
    }

    private void selectItems() {
        storeClerkManagesInventory.printInventory();
        ui.printRandomChoice(5);
        menu.printBalance(customerAccount);
        menu.displayMessage(Text.ASK_FOR_ID);

        String input = ui.input(0).toUpperCase();
        logger.writedev("Input: " + input);
        if(!storeClerkManagesInventory.checkForItem(input)){
            logger.writedev("Check for item: " + !storeClerkManagesInventory.checkForItem(input));
            ui.printRandomChoice(6);
            return;
        }
        Item purchaseItem = storeClerkManagesInventory.getItemInInventory(input);
        if(purchaseItem.getQuantity() == 0){
            logger.writedev("NOT ENOUGH STOCK " + "QTY AMOUNT: " +  purchaseItem.getQuantity() +(purchaseItem.getQuantity() == 0));
            menu.displayMessage(Text.NOT_ENOUGH_PRODUCT_ERROR);
            return;
        }
        int qty = ui.inputGetInt("Please enter the quantity you would like? ");
        if(qty <= 0 || qty > purchaseItem.getQuantity()){
            logger.writedev("QTY Error: " + "QTY AMOUNT: " +  purchaseItem.getQuantity() +(purchaseItem.getQuantity() == 0));
            menu.displayMessage(menu.getAbox().fullbox(Text.errorBig, 50));
            ui.printRandomChoice(6);
            return;
        }
        if(customerAccount.getBalance() < purchaseItem.getPrice() * qty){
            logger.writedev("NOT ENOUGH FUNDS: BALANCE = " + customerAccount.getBalance());
            ui.printRandomChoice(7);
            return;
        }


        cart.addToCart(new CartItem(purchaseItem, qty));
        cart.displayCart();
    }
}