package com.techelevator.items;

public abstract class Item {
    private String itemID;
    private String type;
    private String name;
    private String hasWrapper;

    private int quantity = 100;
    private double price;
    private int sku;

    private String desc;

    private String fstring;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getFstring() {
        return fstring;
    }

    public void setFstring(String fstring) {
        this.fstring = fstring;
    }

    public Item(String type, String itemID, String name,
                double price, String hasWrapper,int quantity, int sku, String desc) {
        this.itemID = itemID;
        this.type = type;
        this.name = name;
        this.hasWrapper = hasWrapper.contains("T")? "Y":"N";
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.desc = desc;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reduceQTY(int num ){
        quantity -= num;
    }

    public void addQTY(int num ){
        quantity += num;
    }

    public String getHasWrapper() {
        return hasWrapper;
    }

    public void setHasWrapper(String hasWrapper) {
        this.hasWrapper = hasWrapper;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s %-25s %-25s  %-7s  %-7s  $%.2f",
                getItemID(),
                getName(),
                getDesc(),
                getHasWrapper(),
                getQuantity() > 0? getQuantity(): "SOLD OUT",
                getPrice());
    }
//    public String toString() {
//        return String.format("%s (%s) - %s: $%.2f", name, type, desc, price);
//    }

}
