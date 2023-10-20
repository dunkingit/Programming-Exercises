package com.techelevator.items;

public class LI extends Item {
    public LI(String type, String itemID, String name, double price, String hasWrapper, int quantity, int sku, String desc) {
        super(type, itemID, name, price, hasWrapper, quantity, sku, desc);
    }

//    public String toString() {
//        return String.format(
//                "%-10s %-25s %-25s  %-7s  %-7s  $%.2f",
//                getItemID(),
//                getName(),
//                getDesc(),
//                getHasWrapper(),
//                getQuantity() > 0? getQuantity(): "SOLD OUT",
//                getPrice());
//    }
}
