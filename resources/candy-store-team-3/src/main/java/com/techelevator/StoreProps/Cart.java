package com.techelevator.StoreProps;
import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.CartItem;
import com.techelevator.items.Item;
import com.techelevator.view.Menu;

import java.util.*;

public class Cart {
    private int inCartqty = 0;
    private double sumCartPrice = 0;
    private List<CartItem> shoppingCart = new ArrayList<>();
    LogFileWriter cartLogger;

    Menu menu;

    public Cart(LogFileWriter cartLogger, Menu menu) {
        this.cartLogger = cartLogger;
        this.menu = menu;
    }

    private String cartHeader = String.format("Your shopping cart:\n" +
                    "%-3s %-15s %-20s %-5s $%s %n"
            , "Qty", "Name", "Description", "Per Item", "Total Item");

    public void showCart() {
        System.out.println(cartHeader);
        for(CartItem cartItem : shoppingCart) {
            menu.displayFormatted("Shopping Cart", cartItem.toString());
        }
    }
    public void displayCart() {
//        System.out.println(String.format("%-10s  %-15s  %-7s  %-7s  $%-10s",
//                "Qty", "Name", "Description", "Per Item", "Total"));
        String headerCart = String.format("%-10s  %-25s  %-20s  %-14s $%-10s",
                "Qty", "Name", "Description", "Per Item", "Total");
        System.out.println(headerCart);
        System.out.println("-".repeat(80));  // Adjust the number as needed
        for (CartItem cartItem : shoppingCart) {
            Item item = cartItem.getItem();
            int quantity = cartItem.getQuantityInCart();
            double totalItemPrice = cartItem.getSumPrice();
            System.out.println(String.format("%-10s  %-25s  %-20s  %-14.2f $%-10.2f",
                    quantity,
                    item.getName(),
                    item.getDesc(),
                    item.getPrice(),
                    totalItemPrice));
        }
        double totalAmount = shoppingCart.stream().mapToDouble(CartItem::getSumPrice).sum();
        System.out.println("-".repeat(80));
        System.out.println(String.format("IN CART TOTAL: $%-10.2f", totalAmount) + "\n\n\n");
    }
    public void addToCart(CartItem ci) {
        inCartqty += ci.getQuantityInCart();
        sumCartPrice += ci.getSumPrice();
        ci.getItem().reduceQTY(inCartqty);
        System.out.println("Successfully added to cart. ");
        this.shoppingCart.add(ci);
    }

    public void removeFromCart(CartItem ci) {
        inCartqty -= ci.getQuantityInCart();
        sumCartPrice -= ci.getSumPrice();
        this.shoppingCart.remove(ci);
    }
    public int getQuantityInCart() {
        return shoppingCart.stream().mapToInt(CartItem::getQuantityInCart).sum();
    }

    public double getInCartTotal() {
        return shoppingCart.stream().mapToDouble(CartItem::getSumPrice).sum();
    }

    public List<CartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void cartStatus() {
        showCart();
        System.out.println(String.format("Number of items in cart: %s\n" +
                "Total in cart: $%.2f", getQuantityInCart(), sumCartPrice));
    }
}





//    public int getQuantityInCart() {
//        int numberItemsInCart = 0;
//        for(CartItem each: shoppingCart) {
//            numberItemsInCart += each.getQuantityInCart();
//        }
//        return numberItemsInCart;
//    }

//    public double getInCartTotal() {
//        double sum = 0;
//        for (CartItem each : shoppingCart) {
//            sum += each.getSumPrice();
//        }
//        return sum;
//    }