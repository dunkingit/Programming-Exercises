package com.techelevator;

import java.io.*;
import java.util.*;

public class FindAndReplace {
//    String promptInputSearchWord;
//    String promptInputReplaceWord;
//    String promptInputSourceFile;
//    String promptInputDestinationFile;
    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);
    StringBuilder text = new StringBuilder();
    public String input(String message){
        System.out.println(message);
        return userInput.nextLine();
    }

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();

    }

    public void run() {
        String promptInputSearchWord = input("What is the search word?");
        String promptInputReplaceWord = input("What is the replacement word?");
        String promptInputSourceFile = input("What is the source file?");

        try (Scanner reader = new Scanner(new File(promptInputSourceFile))) {
            while (reader.hasNextLine()) {
                text.append(reader.nextLine().replaceAll(promptInputSearchWord,
                                promptInputReplaceWord));
                text.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("The source file could not be found. Exiting...");
            System.exit(0);
        };

        //Reading the file
        String promptInputDestinationFile = input("What is the destination file? ");
        if (promptInputSourceFile.equals(promptInputDestinationFile)) {
            System.out.println("Source and destination files are the same. This might corrupt your data. Please provide a different destination.");
            return;
        }

        try (PrintWriter print = new PrintWriter(promptInputDestinationFile)) {
            print.println(text);
            if (print.checkError()) {
                System.out.println("There was an error writing to the destination file.");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("The destination file could not be accessed. Exiting...");
            System.exit(0);
        }




    }


}

