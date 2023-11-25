package com.techelevator.tenmo.model;

import java.lang.reflect.Field;

public class Account {
    private int userId;
    private int accountId;
    private double balance;

    @Override
    public String toString() {
        return "Account Details" + "\n" +
                "user Id =" + userId + "\n" +
                ", account Id =" + accountId + "\n" +
                ", balance = " + balance + "\n" + '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}