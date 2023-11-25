package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookReader {
    static private final String BEGIN_MARKER = "*** START OF";
    static private final String END_MARKER = "*** END OF";
    public static void main(String[] args) {
        /*
         * This book-reader program opens a file that was downloaded from https://www.gutenberg.org/, reads
         * through the copyright information at the top until it finds the start of the book content, and
         * then displays the content to the user. It also counts the total lines of book content between the
         * start and the end markers.
         */
        //data/fairy-tales.txt
        /*Step 1: Prompt the user for a filename*/
        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);
        // Prompt the user for a file path - path should look like "data/jekyll-and-hyde.txt"
        System.out.print("Enter path to the book file: data/fairy-tales.txt");
        String filePath = userInput.nextLine();
        int lineCount = 0;

        File bookFile = new File(filePath);
        try(Scanner fileInput = new Scanner(bookFile))
        {   Scanner pager = new Scanner(System.in);
            boolean inBookText = false;
            while(fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                if (lineOfText.startsWith(BEGIN_MARKER)) {
                    inBookText = true;
                    continue;  // No need to process this line...go to the next
                }

                if (inBookText && lineOfText.length() > 0) {
                    lineCount++;
                    System.out.println(lineCount + ": " + lineOfText);
                }
                if ((lineCount % 10 == 0) && (lineCount > 1))  {
                    System.out.println("Line Count: " + lineCount);
                    System.out.println("Press 'Enter' to continue to the next page");
                    pager.nextLine();
                }

                if (lineOfText.startsWith(END_MARKER)) {
                    break;  // Once the program finds the end, break out of the loop.
                }
            }

//            System.out.println("Press 'Enter' to continue to the next page");
//            new Scanner(System.in).nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + bookFile.getAbsolutePath());
        }
        System.out.println("Found " + lineCount + " lines of text in " + filePath);
    }

    }

