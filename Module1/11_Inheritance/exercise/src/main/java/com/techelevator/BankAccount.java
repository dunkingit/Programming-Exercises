package com.techelevator;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        //A new bank account requires an account holder name and account number.
        // The balance is initialized to the dollar balance given.
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(String accountHolderName, String accountNumber) {
        //A new bank account requires an account holder name and account number.
        // The balance defaults to a 0 dollar balance.
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public int deposit(int amountToDeposit){
        //Adds amountToDeposit to the current balance,
        // and returns the new balance of the bank account.
        // amountToDeposit must be greater than zero.
        this.balance = amountToDeposit > 0? this.balance + amountToDeposit:this.balance;
        return this.balance;
    };


    public int withdraw(int amountToWithdraw){
        boolean positiveWithdraw = amountToWithdraw > 0;
        int transaction = this.balance - amountToWithdraw;
        //Subtracts amountToWithdraw from the current balance,
        // and returns the new balance of the bank account.
        // amountToWithdraw must be greater than zero.
        if(positiveWithdraw){
            this.balance -= amountToWithdraw;
        };
        return this.balance;
    };




    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
