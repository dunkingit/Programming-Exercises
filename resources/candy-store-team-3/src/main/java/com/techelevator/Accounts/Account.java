package com.techelevator.Accounts;

import com.techelevator.Text;
import com.techelevator.filereader.LogFileWriter;

public abstract class Account {
    private double balance = 0;
    LogFileWriter accountLogger;

    public Account() {
    }

    public Account(LogFileWriter accountLogger) {
        this.accountLogger = accountLogger;
    }

    public LogFileWriter getAccountLogger() {
        return accountLogger;
    }

    public void setAccountLogger(LogFileWriter accountLogger) {
        this.accountLogger = accountLogger;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amountToDeposit) {
        double before = this.balance;
        if (amountToDeposit > 0 && amountToDeposit <= 100) {
            balance += amountToDeposit;
        } else {
            System.out.println("Invalid deposit amount. Please deposit an amount between 0 and 100.");
        }
        double after = this.balance;
        accountLogger.writeTransactions("DEPOSIT", before, after);
    }

    public void withdraw(double amountToWithdraw) {
        double before = this.balance;
        if (amountToWithdraw > 0 && balance - amountToWithdraw >= 0) {
            balance -= amountToWithdraw;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
        double after = this.balance;
        accountLogger.writeTransactions("WITHDRAW", before, after);
    }

    public void clearBalance() {
        balance = 0;
        accountLogger.writeTransactions("BALANCE RESET", 0, 0);
    }

    public void printCurrentBalance() {
        System.out.println("Current Balance: " + this.getBalance());
        accountLogger.writeTransactions("PRINT BALANCE", balance, balance);
    }
}