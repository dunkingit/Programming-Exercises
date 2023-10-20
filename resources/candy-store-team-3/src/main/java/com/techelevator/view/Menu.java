package com.techelevator.view;
import com.techelevator.Accounts.Account;
import com.techelevator.items.Item;

import java.io.File;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    box abox = new box();
    public String displayBox(){
        return abox.fullbox("Welcome to our store.\n I hope you are doing well today" +
                "\n I am glad to see you.", 50);
    }

    public box getAbox() {
        return abox;
    }

    public void setAbox(box abox) {
        this.abox = abox;
    }

    public String iterCreateMenu(String[] choice, String message){
        message += "\n";
        for (int i = 0; i < choice.length ; i++) {
            message += String.format("[%s] | %s %n", i + 1, choice[i]);
        }
        return message;
    }

    public void displayMessage(String str){
        System.out.println("\n" + str);
    }

    public void displayFormatted(String word, String longString) {
        String[] newString = longString.trim().split("\\s+");
        String top = "-".repeat(40) + word + "-".repeat(40);
        System.out.println(top);

        if (newString.length >= 8) {
            System.out.printf("%-10s  %-25s %-25s %-7s  %-7s  $%s %-7s %-7s%n",
                    newString[0], newString[1], newString[2], newString[3],
                    newString[4], newString[5], newString[6], newString[7]);
        } else {
            for (String s : newString) {
                System.out.printf("%s ", s);
            }
            System.out.println();
        }

        System.out.println("-".repeat(top.length()));
    }



    public String displayItem(Item name){
        return name.toString();
    }

    public void displayInventory(Map<String, Item> items){
        System.out.println();
        for (Map.Entry<String, Item> each: items.entrySet()){
            System.out.println(each.getValue().toString());
        }
    }

    public void displayFileInfo(File fileObj) {
        System.out.println("File name: " + fileObj.getName());
        System.out.println("Absolute path: " + fileObj.getAbsolutePath());
        System.out.println("Writable: " + fileObj.canWrite());
        System.out.println("Readable: " + fileObj.canRead());
        System.out.println("File size in bytes: " + fileObj.length());
    }

    public void printBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }
}
