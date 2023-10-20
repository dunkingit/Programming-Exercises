package com.techelevator.Inventory;
import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.*;
import com.techelevator.view.Menu;

import java.util.*;

public class ManagesInventory {
    private int itemCounter = 0;
    private Map<String, Item> inventoryMap = new HashMap<>();
    private Map<Integer, Item> OrderedMap = new HashMap<>();

    private LogFileWriter logger;

    Menu menu;

    public ManagesInventory(Menu menu, LogFileWriter logger) {
        this.logger = logger;
        this.menu = menu;
    }

    public void putIntoInventory(String key, Item item) {
        inventoryMap.put(key, item);
    }

    public void iterateInventory() {
        for (String each : sortedByLetterInventoryList()) {
            this.inventoryMap.get(each);
        }
    }

    public void displayInventory(){
        menu.displayInventory(this.inventoryMap);
    }

    public boolean checkForItem(String input) {
        return inventoryMap.containsKey(input);
    }

    public boolean checkOutOfStock(Item item) {
        return item.getQuantity() <= 0;
    }


    public Item getItemInInventory(String input){
        return inventoryMap.get(input);
    };

    public boolean checkSoldOut(String str){
        if (checkOutOfStock(getItemInInventory(str))) {
            menu.displayMessage("Sold Out");
            return false;
        }
        return true;
    }

    public List<String> sortedByLetterInventoryList(){
    List<String> inventoryKeyList =  new ArrayList<>(this.inventoryMap.keySet());
    Collections.sort(inventoryKeyList);
    return inventoryKeyList;
    }

    public void iterStringListsPlaceIntoInventory(List<String[]> array){
        for (String[] each : array) {
            logger.writeInv(Arrays.toString(each));
            stocksInventory(each);
            itemCounter++;
        }

    }

    private Item stocksInventory(String[] array) {
        logger.writeInv(Arrays.toString(array));
        array[1] = array[1].toUpperCase();
        Item aitem;
        switch (array[0]) {
            case "CH":
                aitem = new CH(array[0], array[1], array[2], checkDouble(array[3]), array[4],
                        Integer.parseInt(array[5]), itemCounter, "Chocolate Confectionery");
                break;
            case "SR":
                aitem = new SR(array[0], array[1], array[2], checkDouble(array[3]), array[4],
                        Integer.parseInt(array[5]), itemCounter, "Hard Tack Confectionery");
                break;
            case "HC":
                aitem = new HC(array[0], array[1], array[2], checkDouble(array[3]), array[4],
                        Integer.parseInt(array[5]), itemCounter, "Licorce and Jellies");
                break;
            case "LI":
                aitem = new LI(array[0], array[1], array[2], checkDouble(array[3]), array[4],
                        Integer.parseInt(array[5]), itemCounter, "Sour Flavored");
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + array[0]);
        }

        putIntoInventory(array[1], aitem);

        return aitem;
    }
//
//    "🆔 Id", "🍬 Name", "🎁 Wrapper", "🔢 Quantity", "💲 Price"

    public void printInventory() {
        System.out.println("-".repeat(40) + "Inventory" + "-".repeat(40));
        System.out.printf("%-10s  %-25s %-25s %-7s  %-7s  $%s%n", "Item ID", "Name", "Description", "Wrapper", "Quantity", "Price");
        System.out.println("-".repeat(89));
        organizeItemsIntoMap();
        List<Integer> alist = new ArrayList<>(getOrderedMap().keySet());
        Collections.sort(alist);
        for (int each : alist) {
            Item name = getOrderedMap().get(each);
            System.out.println(name.toString());
            ;
        }
        System.out.println("-------------------------------------------------------------------------");
    }


    public void checkInfo(String[] array) {
        for (int i = 0; i < 3; i++) {
            array[i] = array[i].isEmpty() ? "Unknown" : array[i];
        }
    }

    public void check(){

        for (Map.Entry<String, Item> each: inventoryMap.entrySet()){
            System.out.println(each);
            System.out.println(each.getValue());
        }

        for (Map.Entry<Integer, Item> each: getOrderedMap().entrySet()){
            System.out.println(each);
            System.out.println(each.getValue());
        }

    }

    public double checkDouble(String stringNum) {
        try {
            return Double.parseDouble(stringNum);
        } catch (NumberFormatException e) {
            return 0.00;
        }
    }

    public void organizeItemsIntoMap(){
        for (Item item : inventoryMap.values()) {
            OrderedMap.put(item.getSku(), item);
        }
    }

    public Map<Integer, Item> getOrderedMap() {
        return OrderedMap;
    }

    public void setOrderedMap(Map<Integer, Item> orderedMap) {
        OrderedMap = orderedMap;
    }
}









//    public int checkQuantity(Item currentItem){
//        while (true) {
//            int intInput = menu.userInputInt(enterNumberForQuantity);
//            if(intInput == 0){
//                menu.displayMessage(enteredZeroErrorMessage);
//                continue;
//            }
//            if(intInput > currentItem.getQuantity()){
//                menu.displayMessage(notEnoughProductError);
//                continue;
//            }
//            return intInput;
//        }
//    }