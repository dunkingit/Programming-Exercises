package com.techelevator.filereader;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFileWriter{
 public String specialFileName;
 private final String ERROR_LOG = "ErrorLog.txt";
 private final String TRANSACTIONS = "transactions.txt";
 private final String DEVLOG = "devlog.txt";
 private final String INVENTORYLOG = "inventorylog.txt";

 public LogFileWriter() {
 }

 public LogFileWriter(String fn) {
  this.specialFileName = fn;
 }

 public String getSpecialFileName() {
  return specialFileName;
 }

 public void setSpecialFileName(String specialFileName) {
  this.specialFileName = specialFileName;
 }

 public boolean writedev(String str){
  String log = outputFormat(str);
  return writeLog(DEVLOG, log);
 }

 public boolean writeInv(String str){
  String between = "═".repeat(40) + "\n".repeat(5) + "═".repeat(40) + "\n";
  String log = outputFormat(between + str);
  return writeLog(INVENTORYLOG, log);
 }

 public boolean writeError(String str){
  String log = outputFormat(str);
  return writeLog(ERROR_LOG, log);
 }

 public boolean writeTransactions(String action, double balanceBefore, double balanceAfter){
  LocalDateTime myDateObj = LocalDateTime.now();
  String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
  String output = String.format("%s %s: $%.2f $%.2f", formattedDate, action, balanceBefore, balanceAfter);
  writeLog(TRANSACTIONS, output);
  return true;
 }


 public String outputFormat(String action){
  LocalDateTime myDateObj = LocalDateTime.now();
  String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
  return String.format("%s Event: %s", formattedDate, action);
 }

 public boolean writeLog(String str, String text) {
  try(PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(str, true)))){
   print.println(text);
  }catch(IOException io){
   System.out.println("Error: " + io);
   return false;
  }
  return true;
 }

}

// public String outputFormat(String action, double balanceBefore, double balanceAfter){
//  LocalDateTime myDateObj = LocalDateTime.now();
//  String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//  return String.format("%s %s: $%.2f $%.2f", formattedDate, action, balanceBefore, balanceAfter);
// }