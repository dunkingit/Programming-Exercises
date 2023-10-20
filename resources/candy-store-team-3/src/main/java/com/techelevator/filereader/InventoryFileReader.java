package com.techelevator.filereader;

import com.techelevator.items.Item;
import com.techelevator.view.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class InventoryFileReader{

    private LogFileWriter logger;

    protected String filePath;
    protected String outputFileName;
    protected File fileObj;
    protected String errorFile = "Errorlog.txt";
    Random random = new Random();

    public InventoryFileReader(LogFileWriter logger) {
        this.logger = logger;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public File getFileObj() {
        return fileObj;
    }

    public String getErrorFile() {
        return errorFile;
    }

    public void setErrorFile(String errorFile) {
        this.errorFile = errorFile;
    }

    public List<String[]> stocksAllInventory(String filename) {
        List<String[]> linesFromDoc = new ArrayList<>();
        try (Scanner inputScanner = new Scanner(new File(filename))) {
            while (inputScanner.hasNextLine()) {
                linesFromDoc.add((inputScanner.nextLine() + "\\| " + random.nextInt(101)  ).split("\\|"));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return linesFromDoc;
    }


    public List<String[]> stocksAllInventoryFromDefault(String filename) {
        List<String[]> linesFromDoc = new ArrayList<>();
        try (Scanner inputScanner = new Scanner(new File("inventory.csv"))) {
            while (inputScanner.hasNextLine()) {
                linesFromDoc.add((inputScanner.nextLine() + "\\|" + random.nextInt(101)  ).split("\\|"));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return linesFromDoc;
    }

    public List<String> stocksAllWithRandomInventory(String filename) {
        List<String> linesFromDoc = new ArrayList<>();
        try (Scanner inputScanner = new Scanner(new File(filename))) {
            while (inputScanner.hasNextLine()) {
                linesFromDoc.add(inputScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: " + filename);
        }
        return linesFromDoc;
    }

    public List<String[]> readFromFileIntoInventory(File inventory) {
        List<String[]> linesFromDoc = new ArrayList<>();
        try (Scanner inputScanner = new Scanner(inventory)) {
            while (inputScanner.hasNext()) {
                while (inputScanner.hasNextLine()) {
                    linesFromDoc.add((inputScanner.nextLine() + "\\|" + random.nextInt(101)  ).split("\\|"));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Found. File does not exist.");
        }
        return linesFromDoc;
    }

    public boolean checkForFile(UserInput userInput) {
        while (true) {
            String str = userInput.input("Please input your file name and extension or type 'exit','0' to exit back to the previous menu.");
            this.fileObj = new File(str);
            if (fileObj.exists()) {
                return true;
            } else {
                System.out.println("File not found! Please try again.");
            }
            if(str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("0")){
                return false;
            }
        }
    }

    public void setFileObj(File fileObj) {
        this.fileObj = fileObj;
    }
}
