package com.techelevator.view;

public class box {
    public String fullbox(String str, int boxsize){
        return this.topbox(boxsize) + "\n" +
                (str.contains("\n") ? this.multiCenter(str, boxsize) : this.centerbox(str, boxsize)) +
                this.bottombox(boxsize);
    }

    public String topbox(int num){
        return "╔" + "═".repeat(num - 2) + "╗";
    }

    public String centerbox(String str, int num){
        if (str.length() > num - 2) {
            str = str.substring(0, num - 4) + ".."; // Truncate and add ellipsis to fit the box
        }
        int totalPadding = num - str.length() - 2; // Subtract 2 for the side bars
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return "║" + " ".repeat(leftPadding) + str + " ".repeat(rightPadding) + "║\n";
    }

    public String bottombox(int num){
        return "╚" + "═".repeat(num - 2) + "╝";
    }

    public String multiCenter(String str, int num){
        StringBuilder temp = new StringBuilder();
        for (String each : str.split("\n")){
            temp.append(centerbox(each, num));
        }
        return temp.toString();
    }
}
