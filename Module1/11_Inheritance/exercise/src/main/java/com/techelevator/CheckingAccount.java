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
        final double MAXOVERDRAW = -100.00;
        final int FEE = 10;
        int checkTransaction = this.getBalance() - amountToWithdraw;
        boolean chargeFee = checkTransaction > MAXOVERDRAW && checkTransaction < 0;
        int transaction = chargeFee? amountToWithdraw + FEE:amountToWithdraw;
        if(checkTransaction <= MAXOVERDRAW || amountToWithdraw <= 0){
            return super.withdraw(0);
        };
        return super.withdraw(transaction);
    }
}
