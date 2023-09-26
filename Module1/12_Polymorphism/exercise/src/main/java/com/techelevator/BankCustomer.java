package com.techelevator;

import java.util.List;

public class BankCustomer{
    String name;
    String address;
    String phoneNumber;
    List<Accountable> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Accountable> getAccounts() {
        return accounts;
    }

    public void addAccounts(Accountable newAccount) {
        this.accounts.add(newAccount);
    }

    public boolean isVip(){
        int sum = 0;
        for (Accountable each:getAccounts()){
            sum += each.getBalance();
        };
        return sum >= 25000;
    };
}