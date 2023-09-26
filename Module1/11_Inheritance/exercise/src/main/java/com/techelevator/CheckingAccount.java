package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        final double OVERDRAW_LIMIT = -100.00;
        final int FEE = 10;

        int verifyFunds = this.getBalance() - Math.max(amountToWithdraw, 0);
        boolean chargeFee = verifyFunds > OVERDRAW_LIMIT && verifyFunds < 0;
        int transaction = chargeFee? amountToWithdraw + FEE:amountToWithdraw;
        return super.withdraw(verifyFunds <= OVERDRAW_LIMIT? 0:transaction);
    }
}
