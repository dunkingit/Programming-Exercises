package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/users")
public class TransferController {
    private final TransferDao transferDao;
    private UserDao userDao;
    private AccountDAO accountDAO;

    public TransferController(TransferDao transferDao, UserDao userDao,  AccountDAO accountDAO) {
        this.transferDao = transferDao;
        this.userDao = userDao;
        this.accountDAO = accountDAO;
    }
    @RequestMapping("/sent")
    public List<Transfer> getSentTransfers(Principal principal) {
        return transferDao.getSentTransfersByUserId(accountDAO.getAccountId(principal.getName()));
    }
    @RequestMapping("/received")
    public List<Transfer> getReceivedTransfers(Principal principal) {
        return transferDao.getReceivedTransfersByUserId(accountDAO.getAccountId(principal.getName()));
    }

    @RequestMapping("/pending")
    public List<Transfer> getPendingTransfers(Principal principal) {
        int accountId = accountDAO.getAccountId(principal.getName());
        return transferDao.getPendingTransfersByAcountIdd(accountId);
    }

    @RequestMapping( path = "/{id}/{newstatus}")
    public String updateTransfer(@PathVariable int id, @PathVariable int newstatus) {
        transferDao.changeTransferStatus(newstatus, id);
        return "Update Successful. Thank you for your business";
    }

    @RequestMapping( path = "/request",   method = RequestMethod.POST)
    public String request(@RequestBody Transfer transfer, Principal principal) {
        int getAccountFromId = accountDAO.getAccountIdFromUserId(transfer.getAccount_to());
        int getAccountToId = accountDAO.getAccountId(principal.getName());
        if(getAccountFromId == getAccountToId){
            return "You have appeared to have enter the same account information. Let's try that again. ";
        }
        transfer.setAccount_from(getAccountFromId);
        transfer.setAccount_to(getAccountToId);
        int transfer_id = transferDao.initiateTransfer(transfer);
        transfer.setTransfer_id(transfer_id);
        return "Successfully Requested";
    }

    @RequestMapping( path = "/transfer",   method = RequestMethod.POST)
    public String sendRequest(@RequestBody Transfer transfer, Principal principal) {
        int getAccountFromId = accountDAO.getAccountId(principal.getName());
        int getAccountToId = accountDAO.getAccountIdFromUserId(transfer.getAccount_to());
        if(getAccountFromId == getAccountToId){
            return "You have appeared to have enter the same account information. Let's try that again. ";
        }
        if(accountDAO.getOtherBalanceByAccountId(getAccountFromId) >= transfer.getAmount()){
            transfer.setAccount_from(getAccountFromId);
            transfer.setAccount_to(getAccountToId);
            transfer.setTransfer_status_id(2);
            int transfer_id = transferDao.initiateTransfer(transfer);
            transfer.setTransfer_id(transfer_id);
            if(transfer.getTransfer_id() !=0){
                transferDao.transferAmmount(transfer);
                transferDao.changeTransferStatus(2, transfer.getTransfer_id());
            }
            else {
                System.out.println("Boss Nuttin here. ");
            }
            String returning =  "Successfully Transferred. " + "New balance of user" + accountDAO.getBalance(principal);
            return returning;
        }else{
            return "Insufficent funds. Please try again. ";
        }
    }
}
