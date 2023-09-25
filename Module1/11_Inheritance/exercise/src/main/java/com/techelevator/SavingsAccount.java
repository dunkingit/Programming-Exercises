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
        final double BELOWAMOUNTCHARGEFEE = 150.00;
        final int FEE = 2;
        int checkTransaction = this.getBalance() - amountToWithdraw;
        boolean chargeFee = checkTransaction < BELOWAMOUNTCHARGEFEE;
        int transaction = chargeFee? amountToWithdraw + FEE:amountToWithdraw;

        int checkBalance = this.getBalance() - transaction;
        if(checkBalance < 0 || amountToWithdraw <= 0){
            return super.withdraw(0);
        };
        return super.withdraw(transaction);

    }
}
