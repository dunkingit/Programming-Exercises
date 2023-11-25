package com.techelevator.tenmo.dao;

import java.security.Principal;

public interface AccountDAO {

    /**
     * getCurrentBalance returns an unasked question from the database returns a question object
     *
     * @return Question
     **/
    double getBalance(Principal principal);
    int getAccountId(String username);
    int getUserId(String username);

    public double getOtherBalanceByAccountId(int userid);
    double getOtherBalanceByUserId(int userid);

    int getAccountIdFromUserId(int userid);
}
