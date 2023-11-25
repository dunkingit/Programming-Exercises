package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.services.AccountService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.Print;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class App {

    public static final String API_BASE_URL = "http://localhost:8080/";
    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final Print print = new Print();
    private Account account;
    private AuthenticatedUser authCurrentUser;
    private final RestTemplate restTemplate = new RestTemplate();
    private AccountService accountService;

    public App() {
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        print.printGreeting();
        loginMenu();
        if (authCurrentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && authCurrentUser == null) {
            menuSelection = print.printLoginMenu();
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }


    //Start Registration
    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            print.printErrorMessage();
        }
    }


    //Start Login
    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        authCurrentUser = authenticationService.login(credentials);
        if (authCurrentUser == null) {
            print.printErrorMessage();
        }
        accountService = new AccountService(restTemplate, credentials, authCurrentUser, API_BASE_URL);
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            menuSelection = print.printMainMenu();
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
        consoleService.getAccountBalanceMessage(accountService.getBalance());
	}

	private void viewTransferHistory() {
        print.topTextViewTransfers();
        List<Transfer> transfersS = accountService.getSentTransfers();
        List<Transfer> transfersR = accountService.getReceivedTransfers();
        consoleService.ViewTransfers(transfersS);
        consoleService.ViewTransfers(transfersR);
	}

	private void viewPendingRequests() {
        List<Transfer> pendingTransfers = accountService.getReceivedTransfers();
        print.topTextPendingTransfers("PENDING TRANSFERS");
        consoleService.ViewTransfers(pendingTransfers);
	}

	private boolean sendBucks() {
        List<User> newList = accountService.getUsers();
        print.printUsers(newList);
        int userid = consoleService.getUserIDOrUserName(newList);
        if(userid == 0){
            return false;
        }
        double getTheAmount = consoleService.getAmount();
        if(getTheAmount == 0.0){
            return false;
        }
        Transfer ts = consoleService.sendTransfer(userid, getTheAmount);
        String notice = accountService.sendTransfer(ts);
        return true;
	}

	private boolean requestBucks() {
        List<User> newList = accountService.getUsers();
        print.printUsers(newList);
        int userid = consoleService.getUserIDOrUserName(newList);
        if(userid == 0){
            return false;
        }
        double getTheAmount = consoleService.getAmount();
        if(getTheAmount == 0.0){
            return false;
        }
        Transfer ts = consoleService.requestTransfer(userid, getTheAmount);
        String notice = accountService.sendTransfer(ts);
        return true;
	}

}
