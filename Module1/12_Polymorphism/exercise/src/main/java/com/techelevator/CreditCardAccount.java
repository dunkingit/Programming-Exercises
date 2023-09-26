package com.techelevator;

public class CreditCardAccount implements Accountable{
    String accountHolderName;
    String cardNumber;
    int debt = getBalance();
    int balance;

    public CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
        this.balance = 0 - debt;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int charge(int amountToCharge){

        if(amountToCharge> 0){
            this.debt += amountToCharge;
            return debt;
        }
        return debt;
    };

    public int pay(int amountToPay){
        if(amountToPay> 0){
            this.debt -= amountToPay;
            return debt;
        }
        return debt;
    };

    public int getBalance() {
        this.balance = -debt;
        return this.balance;
    }

}
