package com.techelevator.Accounts;

import com.techelevator.Text;

public abstract class Account {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amountToDeposit) {


        if (amountToDeposit > 0 && amountToDeposit <= 100) {
            balance += amountToDeposit;
        } else {
            System.out.println("Invalid deposit amount. Please deposit an amount between 0 and 100.");
        }
    }

    public void withdraw(double amountToWithdraw) {
        if (amountToWithdraw > 0 && balance - amountToWithdraw >= 0) {
            balance -= amountToWithdraw;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }

    }

    public void clearBalance() {
        balance = 0;
    }

    public void printCurrentBalance() {
        System.out.println("Current Balance: " + this.getBalance());
    }
}