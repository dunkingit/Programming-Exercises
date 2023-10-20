package com.techelevator.StoreProps;
import com.techelevator.Accounts.Account;
import com.techelevator.Text;
import com.techelevator.view.Menu;
import com.techelevator.view.UserInput;

import java.util.Scanner;

public class Register {
    Account customer;
    Account vendor;
    Menu menu;
    Cart cart;
    Money money;

    public Register(Account customer, Account vendor, UserInput menu, Cart cart) {
        this.customer = customer;
        this.vendor = vendor;
        this.menu = menu;
        this.cart = cart;
    }
    public void transferFunds(Account customer, Account vendor, double transferAmount){
    customer.withdraw(transferAmount);
    vendor.deposit(transferAmount);
    };


    public boolean checkout(){
        money = new Money();
        if(this.cart.getInCartTotal() <= this.customer.getBalance()){
            transferFunds(customer, vendor, cart.getInCartTotal());
            money.getChange(customer);
            customer.withdraw(customer.getBalance());
            System.out.println(Text.thankyou);
            return true;
        }else {
            System.out.println("It seems that you do not have enough money to purchase these items" +
                    "Please insert more money and try again.");
        }
        return false;
    }

    public int insertMoneyOption(int num) {
        String overage = "Sorry at this time we can not accept bills over a $100\n" +
                "Please try again";
        String over1000 = "We're sorry but depositing that much would exceed the maximum allowance of $1000";
        String invalidAmmount = "You have entered a invalid amount.\n" +
                "Please try again. ";

        if (num + customer.getBalance() > 1000){
            menu.displayMessage(over1000);
        } else if (num < 0){
            menu.displayMessage(invalidAmmount);
        }else if(num > 100){
            menu.displayMessage(overage);
        }else {
            menu.displayMessage(Text.thankyou);
            return num;
        }
        return 0;
    }
}
