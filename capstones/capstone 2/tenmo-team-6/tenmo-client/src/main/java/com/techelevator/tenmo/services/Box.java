package com.techelevator.tenmo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Box {
    private int num = 50;
    private final String top = "╔" + "═".repeat(num - 2) + "╗";
    private final String bottom = "╚" + "═".repeat(num - 2) + "╝";
    private final String emptyMiddle = "║"+ " ".repeat(num - 2)  +"║";
    String nl = " \n";

    public Box(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String box(int num, String astatement, String balance) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy - HH:mm:ss");
        String date = dateTime.format(formatter);

        return  top + nl
                + emptyMiddle + nl
                + centerBox(astatement, num) + nl
                + emptyMiddle + nl
                + centerBox(date, num) + nl
                + emptyMiddle + nl
                + centerBox(balance, num) + nl
                + emptyMiddle + nl
                + bottom + nl;

    }
    public String centerBox(String str, int num) {
        int totalPadding = num - str.length() - 2; // Subtract 2 for the side bars
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return "║" + " ".repeat(leftPadding) + str + " ".repeat(rightPadding) + "║";
    }

}
