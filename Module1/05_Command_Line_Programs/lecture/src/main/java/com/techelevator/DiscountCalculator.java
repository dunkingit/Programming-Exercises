package com.techelevator;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {
        String greet = "Welcome to the Discount Calculator";
        String question = "Enter the discount amount (w/out percentage): ";
        String question_2 = "Please provide a series of prices (space separated): ";
        String confirm = "You have entered: ";

        System.out.println(greet);
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double num = Integer.parseInt(input);

        System.out.print(question_2);
        input = scanner.nextLine();
        String[] array_Percentages = input.split(" ");
        int[] int_Array = new int[array_Percentages.length];

        for (int i = 0; i <array_Percentages.length; i++) {
            int_Array[i] = Integer.parseInt(array_Percentages[i]);
        }

        int_Array[0] += 10;

        System.out.print(Arrays.toString(int_Array));


    };
}