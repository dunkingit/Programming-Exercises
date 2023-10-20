package com.techelevator.StoreProps;

import com.techelevator.Accounts.Account;
import com.techelevator.filereader.LogFileWriter;

public class Money {
    private static final int[] MONEY_VALUES = {2000, 1000, 500, 100, 25, 10, 5, 1};
    private static final String[] SINGULAR_NAMES = {"Twenty", "Ten", "Five", "Dollar", "Quarter", "Dime", "Nickel", "Penny"};
    private static final String[] PLURAL_NAMES = {"Twenties", "Tens", "Fives", "Dollars", "Quarters", "Dimes", "Nickels", "Pennies"};

    private LogFileWriter logger;

    public Money(LogFileWriter logger) {
        this.logger = logger;
    }

    public void getChange(Account account){
        double changeToGive = (account.getBalance());
        double change = account.getBalance() * 100;
        String textChange = "";
        int counter = 0;
        while(change >= 0 && counter <= 7){
            int div = (int)(change / MONEY_VALUES[counter]);
            if (div > 0){
                if(div == 1){
                    change = Math.round(change - (div * MONEY_VALUES[counter]));
                    textChange += "(" + div + ") " + SINGULAR_NAMES[counter] + " ";
                }else{
                    change = Math.round(change - (div * MONEY_VALUES[counter]));
                    textChange += "(" + div + ") " + PLURAL_NAMES[counter] + " ";
                }
            }
            counter++;
        }
        String out= "changeToGive = ("+ account.getBalance() +")\n" +
                "Text Change: " + textChange + String.format("Change: $%.2f %n" ,(changeToGive)) + "\n";

        System.out.printf("Change: $%.2f %n" ,(changeToGive));
        System.out.println(textChange);
        logger.writeTransactions(out + "Giving Change: ", changeToGive, 0);
    }
}
