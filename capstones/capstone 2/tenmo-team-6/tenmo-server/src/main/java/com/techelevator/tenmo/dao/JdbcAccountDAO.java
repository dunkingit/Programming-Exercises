package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class JdbcAccountDAO implements AccountDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public double getBalance(Principal principal) {
        double checkaccount = 0;
        String sql = "select balance\n" +
                "from tenmo_user\n" +
                "join account\n" +
                "on account.user_id = tenmo_user.user_id\n" +
                "where account.user_id = (select user_id from tenmo_user where username = ?);";
        try {
            double results = jdbcTemplate.queryForObject(sql, double.class, principal.getName());
            checkaccount = results;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return checkaccount;
    }

    public double getOtherBalanceByUserId(int userid) {
        System.out.println(userid);
        double checkaccount = 0;
        String sql = "select balance\n" +
                "from tenmo_user\n" +
                "join account\n" +
                "on account.user_id = tenmo_user.user_id\n" +
                "where account.user_id = ?;";
        try {
            double results = jdbcTemplate.queryForObject(sql, double.class, userid);
            checkaccount = results;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return checkaccount;
    }


    public double getOtherBalanceByAccountId(int userid) {
        System.out.println(userid);
        double checkaccount = 0;
        String sql =  "SELECT balance " +
                "FROM tenmo_user " +
                "JOIN account ON account.user_id = tenmo_user.user_id " +
                "WHERE account.account_id = ?;";
        try {
            double results = jdbcTemplate.queryForObject(sql, double.class, userid);
            checkaccount = results;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return checkaccount;
    }

    @Override
    public int getAccountId(String username) {
        int gotAccountId = -1;
        String Sql = "SELECT account_id " +
                     "FROM tenmo_user " +
                     "JOIN account ON account.user_id = tenmo_user.user_id " +
                     "WHERE tenmo_user.username = ?;";
        try {
            int gettingAccountId = jdbcTemplate.queryForObject(Sql, int.class, username);
            gotAccountId = gettingAccountId;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return gotAccountId;
    }

    @Override
    public int getUserId(String username) {
        int gotUserId = -1;
        String Sql = "SELECT user_id FROM tenmo_user WHERE username = ?;";
        try {
            int gettingUserId = jdbcTemplate.queryForObject(Sql, int.class, username);
            gotUserId = gettingUserId;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return gotUserId;
    }

    @Override
    public int getAccountIdFromUserId(int userid) {
        System.out.println(userid);
        int account_id = 0;
        String sql = "select account_id\n" +
                "from tenmo_user\n" +
                "join account\n" +
                "on account.user_id = tenmo_user.user_id\n" +
                "where account.user_id = ?;";
        try {
            int results = jdbcTemplate.queryForObject(sql, int.class, userid);
            account_id = results;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return account_id;
    }
    private Account mapRowToAccount(SqlRowSet results){
        Account account = new Account();
        account.setAccountId(results.getInt("account_id"));
        account.setBalance(results.getDouble("balance"));
        account.setUserId(results.getInt("user_id"));
        return account;
    }

}





//    public Account makeAccountById(int id) {
//        Account checkaccount = null;
//        String sql = "select account_id, balance, account.user_id\n" +
//                "from tenmo_user\n" +
//                "join account\n" +
//                "on account.user_id = tenmo_user.user_id\n" +
//                "where account.user_id = ?;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
//
//        if(results.next()){
//            checkaccount = mapRowToAccount(results);
//        }
//        return checkaccount;
//    }