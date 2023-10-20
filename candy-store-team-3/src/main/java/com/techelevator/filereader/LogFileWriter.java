package com.techelevator.filereader;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

 public class LogFileWriter{

//    public String outputFormat(String action, double balanceBefore, double balanceAfter){
//        LocalDateTime myDateObj = LocalDateTime.now();
//        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//        return String.format("%s %s: $%.2f $%.2f", formattedDate, action, balanceBefore, balanceAfter);
//    }
//
//    public String outputFormat(String action){
//        LocalDateTime myDateObj = LocalDateTime.now();
//        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//        return String.format("%s Event: %s", formattedDate, action);
//    }
//
//    public boolean writeLog(String str) {
//        try(PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(true)))){
//            print.println(str);
//        }catch(IOException io){
//            System.out.println("Error: " + io);
//            return false;
//        }
//        return true;
//    }
}