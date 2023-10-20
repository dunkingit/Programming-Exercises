package com.techelevator.items;

import java.util.Arrays;

public class CartItem{
    private Item item;
    private int quantityInCart;
    private double sumPrice;

    public CartItem(Item item, int quantityInCart) {
        this.item = item;
        this.quantityInCart = quantityInCart;
        this.sumPrice = item.getPrice() * quantityInCart;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public int getQuantityInCart() {
        return quantityInCart;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-15s %-20s %-5.2f $%.2f",
                quantityInCart, item.getName(), item.getDesc(), item.getPrice(), sumPrice);
    }
}
