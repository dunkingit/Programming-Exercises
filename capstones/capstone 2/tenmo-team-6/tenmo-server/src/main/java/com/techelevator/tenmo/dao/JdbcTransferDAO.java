package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcTransferDAO implements TransferDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Transfer type
    //1. Request
    //2. Send

    //Transfer Status
    //1. Pending
    //2. Approved
    //3. Rejected

    public int initiateTransfer(Transfer transfer) {
            String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                    "VALUES (?, ?, ?, ?, ?) RETURNING transfer_id;";
            try {
                return jdbcTemplate.queryForObject(sql, int.class,
                        transfer.getTransfer_type_id(),
                        transfer.getTransfer_status_id(),
                        transfer.getAccount_from(),
                        transfer.getAccount_to(),
                        transfer.getAmount());

            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
        }

    public void transferAmmount(Transfer transfer){
        System.out.println("Inner trigger");
        String sqlWithdraw = "UPDATE account SET balance = balance - ? WHERE account_id= ?;";
        String sqlDeposit = "UPDATE account SET balance = balance - ? WHERE account_id = ?;";
        try {
            System.out.println("Try trigger");
            jdbcTemplate.update("START TRANSACTION;");
            jdbcTemplate.update(sqlWithdraw, transfer.getAmount(), transfer.getAccount_from());
            jdbcTemplate.update(sqlDeposit, transfer.getAmount(), transfer.getAccount_to());
            jdbcTemplate.update("COMMIT;");
            System.out.println("Successful commit");
        } catch (Exception e) {
            System.out.println("Non successful commit");
            jdbcTemplate.update("ROLLBACK;");
            throw e;
        }
    }

    public void changeTransferStatus(int changeTo, int transfer_id){
        String sql = "UPDATE transfer SET transfer_status_id = ? where transfer_id = ?;";
        try {
            jdbcTemplate.update("START TRANSACTION;");
            jdbcTemplate.update(sql, changeTo, transfer_id);
            jdbcTemplate.update("COMMIT;");
            System.out.println("Successful change status");
        } catch (Exception e) {
            System.out.println("Non successful commit");
            jdbcTemplate.update("ROLLBACK;");
            throw e;
        }
    }

    public int getTransfer_Type_Transfer_Type_Id(String transferTypeDesc) {
        int num = -1;
        String Sql = "SELECT transfer_type_id FROM transfer_type WHERE transfer_type_desc = ?;";;
        try {
            int newnum = jdbcTemplate.queryForObject(Sql, Integer.class, transferTypeDesc);
            num = newnum;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return num;
    }

    public int getTransfer_Type_Transfer_Type_Desc(int id) {
        int num = -1;
        String Sql = "SELECT transfer_type_desc FROM transfer_type WHERE transfer_type_id= ?;";
        try {
            int newnum = jdbcTemplate.queryForObject(Sql, Integer.class, id);
            num = newnum;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return num;
    }

    public int getTransfer_Status_Transfer_Status_Id(String transferStatusDesc) {
        int num = -1;
        String Sql = "SELECT transfer_status_id FROM transfer_status WHERE transfer_status_desc = ?;";
        try {
            int newnum =  jdbcTemplate.queryForObject(Sql, Integer.class, transferStatusDesc);
            num = newnum;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return -1;
    }

    public int getTransfer_Status_Transfer_Status_Id(int id) {
        int num = -1;
        String Sql = "SELECT transfer_status_desc FROM transfer_status WHERE transfer_status_id = ?;";
        try {
            int newnum = jdbcTemplate.queryForObject(Sql, int.class, id);
            num = newnum;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return num;
    }

    public List<Transfer> getSentTransfersByUserId(int accountId) {
        List<Transfer> sentTransfers = new ArrayList<>();
        String sql = "select \n" +
                "transfer_id, \n" +
                "transfer_status.transfer_status_desc, \n" +
                "transfer_type.transfer_type_desc, \n" +
                "transfer_type.transfer_type_id, \n" +
                "transfer.transfer_status_id, \n" +
                "account_from, \n" +
                "account_to, \n" +
                "amount \n" +
                "\n" +
                "from transfer_status\n" +
                "join transfer on transfer.transfer_status_id = transfer_status.transfer_status_id\n" +
                "join transfer_type on transfer.transfer_type_id = transfer_type.transfer_type_id\n" +
                "join account on transfer.account_to = account.account_id\n" +
                "join tenmo_user on account.user_id = tenmo_user.user_id \n" +
                "where transfer.account_from = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                sentTransfers.add(transfer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return sentTransfers;
    }

    public List<Transfer> getPendingTransfersByAcountIdd(int accountId) {
        List<Transfer> sentTransfers = new ArrayList<>();
        String sql = "select \n" +
                "transfer_id, \n" +
                "transfer_status.transfer_status_desc, \n" +
                "transfer_type.transfer_type_desc, \n" +
                "transfer_type.transfer_type_id, \n" +
                "transfer.transfer_status_id, \n" +
                "account_from, \n" +
                "account_to, \n" +
                "amount \n" +
                "\n" +
                "from transfer_status\n" +
                "join transfer on transfer.transfer_status_id = transfer_status.transfer_status_id\n" +
                "join transfer_type on transfer.transfer_type_id = transfer_type.transfer_type_id\n" +
                "join account on transfer.account_to = account.account_id\n" +
                "join tenmo_user on account.user_id = tenmo_user.user_id \n" +
                "where transfer.account_to = ? and transfer.transfer_status_id = 1;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                sentTransfers.add(transfer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return sentTransfers;
    }
    //Transfer type
    //1. Request
    //2. Send

    //Transfer Status
    //1. Pending
    //2. Approved
    //3. Rejected
    public List<Transfer> getRequestTransfersByAcountIdd(int accountId) {
        List<Transfer> sentTransfers = new ArrayList<>();
        String sql = "select \n" +
                "transfer_id, \n" +
                "transfer_status.transfer_status_desc, \n" +
                "transfer_type.transfer_type_desc, \n" +
                "transfer_type.transfer_type_id, \n" +
                "transfer.transfer_status_id, \n" +
                "account_from, \n" +
                "account_to, \n" +
                "amount \n" +
                "\n" +
                "from transfer_status\n" +
                "join transfer on transfer.transfer_status_id = transfer_status.transfer_status_id\n" +
                "join transfer_type on transfer.transfer_type_id = transfer_type.transfer_type_id\n" +
                "join account on transfer.account_to = account.account_id\n" +
                "join tenmo_user on account.user_id = tenmo_user.user_id \n" +
                "where transfer.account_to = ? and transfer.transfer_type_id = 1;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                sentTransfers.add(transfer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return sentTransfers;
    }

    public List<Transfer> getReceivedTransfersByUserId(int accountId) {
        List<Transfer> receivedTransfers = new ArrayList<>();
        String sql = "select \n" +
                "transfer_id, \n" +
                "transfer_status.transfer_status_desc, \n" +
                "transfer_type.transfer_type_desc, \n" +
                "transfer_type.transfer_type_id, \n" +
                "transfer.transfer_status_id, \n" +
                "account_from, \n" +
                "account_to, \n" +
                "amount \n" +
                "\n" +
                "from transfer_status\n" +
                "join transfer on transfer.transfer_status_id = transfer_status.transfer_status_id\n" +
                "join transfer_type on transfer.transfer_type_id = transfer_type.transfer_type_id\n" +
                "join account on transfer.account_to = account.account_id\n" +
                "join tenmo_user on account.user_id = tenmo_user.user_id \n" +
                "where transfer.account_to = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                receivedTransfers.add(transfer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return receivedTransfers;
    }
    private Transfer mapRowToTransfer(SqlRowSet results) {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(results.getInt("transfer_id"));
        transfer.setTransfer_type_id(results.getInt("transfer_type_id"));
        transfer.setTransfer_status_id(results.getInt("transfer_status_id"));
        transfer.setTransfer_type_desc(results.getString("transfer_type_desc"));
        transfer.setTransfer_status_desc(results.getString("transfer_status_desc"));
        transfer.setAccount_from(results.getInt("account_from"));
        transfer.setAccount_to(results.getInt("account_to"));
        transfer.setAmount(results.getDouble("amount"));
        return transfer;
    }

}
