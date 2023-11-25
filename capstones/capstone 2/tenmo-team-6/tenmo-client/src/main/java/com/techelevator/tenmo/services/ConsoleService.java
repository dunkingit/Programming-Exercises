package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.util.*;

public class ConsoleService {
    private final Scanner scanner = new Scanner(System.in);
    private final Util util = new Util();
    private final Print print = new Print();
    private final List<String> byUserName = new ArrayList<>();
    private final List<String> byUserId = new ArrayList<>();
    private final List<String> listForCheckingUsernameUserId = new ArrayList<>();
    private final String horizonalStringLine = "-".repeat(50);
    private final Box box = new Box(50);
    String[] report = {"ID", "FROM", "TO", "TYPE", "STATUS", "AMOUNT"};

    public void getAccountBalanceMessage(double balance) {
        String accountInfo = "Account Balance Statement";
        String messageBalance = String.format("Your current account balance is: $%.2f ", balance);
        System.out.println(box.box(50, accountInfo, messageBalance));
    }

    public UserCredentials promptForCredentials() {
        return new UserCredentials(input("Username: "), input("Password: "));
    }

    public String promptSelectUserByUsernameOrUserId(List<String> byUserId, List<String> byUserName){
        while(true) {
            print.printPromptForUsernameAndUserId();
            String enteredSelection = scanner.nextLine().toLowerCase();
            if(enteredSelection.equals("0")){
                System.out.println("Exiting");
                return "0";
            }

            if(byUserName.contains(enteredSelection)){
                if(util.confirmSelction(enteredSelection) == 1){
                    return byUserId.get(byUserId.indexOf(enteredSelection));
                }
            }else if (byUserId.contains(enteredSelection)){
                if(util.confirmSelction(enteredSelection) == 1){
                    return enteredSelection;
                }
            }
            pause();
        }
    }


    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    //List Maintenance
    public boolean clearUserLists(){
        byUserId.clear();
        byUserName.clear();
        listForCheckingUsernameUserId.clear();
        return (byUserId.isEmpty() && byUserName.isEmpty());
    }

    public boolean populateUserListsForMatching(List<User> users) {
            for(User each: users){
                byUserName.add(each.getUsername().toLowerCase());
                byUserId.add(String.valueOf(each.getId()));
                listForCheckingUsernameUserId.add(each.getUsername().toLowerCase());
                listForCheckingUsernameUserId.add(String.valueOf(each.getId()));
            }
            return !users.isEmpty();
    }

    public int getUserIDOrUserName(List<User> users){
        populateUserListsForMatching(users);
        String returnedString = promptSelectUserByUsernameOrUserId(byUserId, byUserName);
        clearUserLists();
        return Integer.parseInt(returnedString);
    }



    public double getAmount(){
        while(true) {
            System.out.println("Enter the amount: \nEnter 0 to exit and return to the previous menu");
            double amount = util.promptForDouble();
            return amount;
        }
    }


    public void ViewTransfers(List<Transfer> transferList){
        for(Transfer transfer: transferList){
            print.printTransfer(transfer);
        }
    }


    public Transfer createTransfer(int user_id_send, double amount, String type, String status){
        Transfer transfer = new Transfer();
        transfer.setTransfer_type_id(2);
        transfer.setTransfer_type_desc("Send");
        transfer.setTransfer_status_desc("Pending");
        transfer.setTransfer_status_id(1);
        transfer.setAccount_from(0);
        transfer.setAccount_to(user_id_send);
        transfer.setAmount(amount);
        return transfer;
    }

    public Transfer requestTransfer(int user_id_send, double amount){
        Transfer transfer = new Transfer();
        transfer.setTransfer_type_id(1);
        transfer.setTransfer_type_desc("Request");
        transfer.setTransfer_status_desc("Pending");
        transfer.setTransfer_status_id(1);
        transfer.setAccount_from(user_id_send);
        transfer.setAccount_to(0);
        transfer.setAmount(amount);
        return transfer;
    }

    public Transfer sendTransfer(int user_id_send, double amount){
        Transfer transfer = new Transfer();
        transfer.setTransfer_type_id(2);
        transfer.setTransfer_type_desc("Send");
        transfer.setTransfer_status_desc("Pending");
        transfer.setTransfer_status_id(1);
        transfer.setAccount_from(0);
        transfer.setAccount_to(user_id_send);
        transfer.setAmount(amount);
        return transfer;
    }
}
