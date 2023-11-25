package com.techelevator.tenmo.services;

import java.util.Scanner;

public class Util {

    String nl = " \n";
    private final int spaces1 = -12;
    private final int spaces2 = -20;
    private final String checkConfirm = "Please confirm you selection: ";
    private final String invalidNumber = "You have entered an invalid number.\n Please try again";
    private final Scanner scanner = new Scanner(System.in);
    private final String main3Column = "%" + spaces1 + "s" + "%" + spaces2 + "s" + "%" + spaces2 + "s";
    private final String main2Column = "%" + spaces1 + "s" + "%" + spaces2 + "s";
    private final String horizonalStringLine = "-".repeat(50);

    public String returnFormatted2(){
        return main2Column;
    }

    public String getMain3Column() {
        return main3Column;
    }

    public String getMain2Column() {
        return main2Column;
    }

    public int chooseByNumberChoice(String[] array, String top, String bottom, boolean exit){
        while(true) {
            System.out.println(top + iterChoice(array, exit) + bottom);
            int chosenNumber = promptForInt();
            if (chosenNumber == -1){
                return -1;
            }
            if(intWithinRange(0, array.length - 1, chosenNumber)){
                return chosenNumber;
            }
        }
    }

    public int promptForInt() {
        while(true) {
            try {
                String choice = scanner.nextLine();
                if(choice.equals("0")){
                    System.out.println("Exiting");
                    return 0;
                }
                return Integer.parseInt(choice);
            } catch (NullPointerException | NumberFormatException exception) {
                System.out.println(invalidNumber);
                return -2;
            }
        }
    }

    public double promptForDouble() {
        while(true) {
            try {
                String choice = scanner.nextLine();
                if(choice.equals("0")){
                    System.out.println("Exiting");
                    return 0;
                }
                return Double.parseDouble(choice);
            } catch (NullPointerException | NumberFormatException exception) {
                System.out.println(invalidNumber);
                return -2;
            }
        }
    }

    public String iterChoice(String[] array, boolean exit){
        String addExit = "[" + 0 + "] " + "Exit" + " \n";
        String choices = "\n";
        int Counter = 0;
        for (String each : array) {
            if(exit && Counter == 0){
                Counter++;
                continue;
            }
            choices += "[" + Counter + "] " + each + " \n";
            Counter++;
        }
        return exit? choices + addExit:choices;
    }

    public boolean intWithinRange(int start, int end, int select){
        return select <= end && select >= start && select > -1;
    }

    public int confirmSelction(String selection){
        return chooseByNumberChoice(new String[]{"No", "Yes"},
                "", checkConfirm + selection, false);
    }

    public int getApproveRejectOptions() {
        String selection = "Don't approve or reject";
        return chooseByNumberChoice(new String[]{"Aprroval", "Reject"},
                "", checkConfirm + selection, false);
    }

    public String standardColumn(String[] array, String header, String aboveColumns, String formatting){
        String columns = "";
        if(array.length == 2){
            columns = String.format(main2Column, array[0], array[1]);
        }
        if(array.length == 3){
            columns = String.format(main2Column, array[0], array[1]);
        }
        return header + nl
                + horizonalStringLine + nl
                + aboveColumns + nl
                + columns + nl
                + horizonalStringLine + nl;
    }

    public String otherColumn(String[] array, String header, String aboveColumns, String formatting){
        System.out.println(array.length);
        System.out.println(formatting);
        String columns = String.format(formatting, array[0], array[1], array[2], array[3], array[4], array[5]);
            return header + nl
                    + horizonalStringLine + nl
                    + aboveColumns + nl
                    + columns + nl
                    + horizonalStringLine + nl;
        }
    }


