package com.techelevator.tenmo.controller;
import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountDAO accountDAO;

    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public double getCurrentBalance(Principal principal){
        return accountDAO.getBalance(principal);
    }

//    @RequestMapping(path = "/accountid", method = RequestMethod.GET)
//    public int getAccountId(Principal principal){
//        return accountDAO.getAccountId(principal);
//    }
//
//    @RequestMapping(path = "/userid", method = RequestMethod.GET)
//    public int getUserId(Principal principal){
//        return accountDAO.getUserId(principal);
//    }
}
