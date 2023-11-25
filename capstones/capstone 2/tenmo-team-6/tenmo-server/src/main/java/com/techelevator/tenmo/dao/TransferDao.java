package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    int initiateTransfer(Transfer transfer);
    void transferAmmount(Transfer transfer);

    List<Transfer> getSentTransfersByUserId(int userId);

    void changeTransferStatus(int changeTo, int transfer_id);

    List<Transfer> getReceivedTransfersByUserId(int userId);

    List<Transfer> getPendingTransfersByAcountIdd(int accountId);
}
