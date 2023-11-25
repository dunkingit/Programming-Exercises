package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.lang.reflect.Field;
import java.util.List;

public class Print {

    Util util = new Util();
    private final String[] loginMenu = {"Exit", "Register", "Login"};
    private final String[] mainMenu = {"Exit", "View your current balance", "View your past transfers", "View your pending requests",
            "Send TE bucks", "Request TE bucks"};
    private final String greeting = "*".repeat(21) + "\n* Welcome to TEnmo! *\n" + "*".repeat(21);

    public void printGreeting(){
        System.out.println(greeting);
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int printLoginMenu() {
        return util.chooseByNumberChoice(loginMenu, "", "Please choose an option: ", true);
    }

    public int printMainMenu() {
        return util.chooseByNumberChoice(mainMenu, "", "Please choose an option: ", true);
    }

    public void printUsers(List<User> users){
        for(User each: users){
            System.out.printf(util.returnFormatted2() + "\n", each.getId(), each.getUsername());
        }
    }

    public void printPromptForUsernameAndUserId(){
        String select = "Please enter either the whole User ID OR the whole Username:";
        String zeroCancel =   "\n" + "OR Press (0 to cancel):" + "\n";
        System.out.println(select + zeroCancel);
    }

    public void topTextViewTransfers() {
        String view = "View";
        String transfers = "Transfers";
        String[] columnNames = {"ID", "FROM", "TO", "TYPE", "STATUS", "AMOUNT"};
        String top =  util.otherColumn(columnNames, view + " " + transfers, transfers, transferFormatWithoutMoney());
        System.out.println(top);
    }

    public void topTextPendingTransfers(String action) {
        String[] columnHeaders = {"ID", "TO", "AMOUNT"};
        String top =  util.standardColumn(columnHeaders, action, "Pending", "");
        System.out.println(top);
    }

    public void topTextSendReceive(String action) {
        String[] columnNames = {"ID", "NAME"};
        String top = util.standardColumn(columnNames, action + " " + "TE Bucks", "Users", "");
        System.out.println(top);
    }
    //Transfer type
    //1. Request
    //2. Send

    //Transfer Status
    //1. Pending
    //2. Approved
    //3. Rejected

    public void printTransfer(Transfer transfer){
        System.out.printf(transferFormat(),
                transfer.getTransfer_id(),
                transfer.getAccount_from(),
                transfer.getAccount_to(),
                transfer.getTransfer_type_desc(),
                transfer.getTransfer_status_desc(),
                transfer.getAmount());
    }

    public String transferFormat(){
        int id = 12;
        int fromid = 12;
        int toid = 12;
        int transfertype = 12;
        int statusdesc = 12;
        String whole = iterFormatString(new int[] {id, fromid, toid, transfertype, statusdesc});
        whole += "$%,.2f%n";
        return whole;

    }

    public String transferFormatWithoutMoney(){
        int id = 12;
        int fromid = 12;
        int toid = 12;
        int transfertype = 12;
        int statusdesc = 12;
        String whole = iterFormatString(new int[] {id, fromid, toid, transfertype, statusdesc});
        whole += "%"+ id +"s%n";
        return whole;

    }

    public String iterFormatString(int[] array){
        String addTo = "";
        for (int each: array){
            addTo += "%-" + each + "s ";
        }
        return addTo;
    }
}
