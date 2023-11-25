package com.techelevator;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        final double MAINTENANCE_AMOUNT = 150.00;
        final int FEE = 2;
        int verifyFunds = this.getBalance() - Math.max(amountToWithdraw, 0);;
        boolean chargeFee = verifyFunds < MAINTENANCE_AMOUNT;
        int transaction = chargeFee? amountToWithdraw + FEE :amountToWithdraw;
        return super.withdraw(this.getBalance() - transaction >= 0? transaction:0);

    }
}
