package com.techelevator.view;
import com.techelevator.Text;

import java.util.Scanner;

import java.util.Random;

import static com.techelevator.Text.*;

public class UserInput extends Menu{

    public void printRandomChoice(int num) {
        Random rand = new Random();
        if (num == 0) {
            System.out.println(PROGRAMMING_CHOICES[rand.nextInt(PROGRAMMING_CHOICES.length)]);
        } else if (num == 1) {
            System.out.println(OTHER_CHOICES[rand.nextInt(OTHER_CHOICES.length)]);
        } else if (num == 2) {
            System.out.println(CAVE_JOHNSON_QUOTES[rand.nextInt(CAVE_JOHNSON_QUOTES.length)]);
        } else if (num == 3) {
            System.out.println(CUSTOMER_GREETINGS[rand.nextInt(CUSTOMER_GREETINGS.length)]);
        } else if (num == 4) {
            System.out.println(CUSTOMER_NAME_GREETINGS[rand.nextInt(CUSTOMER_NAME_GREETINGS.length)]);
        }else if (num == 5) {
            System.out.println(programmerGreetings[rand.nextInt(programmerGreetings.length)]);
        }else if (num == 6) {
            System.out.println(wrongInputGreetings[rand.nextInt(wrongInputGreetings.length)]);
        }else if (num == 7) {
            System.out.println(insufficientFundsGreetings[rand.nextInt(insufficientFundsGreetings.length)]);
        }else if (num == 8) {
            System.out.println(ENTER_MONEY[rand.nextInt(ENTER_MONEY.length)]);
        }

    }

    public String getRandomChoice(int num) {
        Random rand = new Random();
        String selectedChoice = "";

        if (num == 0) {
            selectedChoice = PROGRAMMING_CHOICES[rand.nextInt(PROGRAMMING_CHOICES.length)];
        } else if (num == 1) {
            selectedChoice = OTHER_CHOICES[rand.nextInt(OTHER_CHOICES.length)];
        } else if (num == 2) {
            selectedChoice = CAVE_JOHNSON_QUOTES[rand.nextInt(CAVE_JOHNSON_QUOTES.length)];
        } else if (num == 3) {
            selectedChoice = CUSTOMER_GREETINGS[rand.nextInt(CUSTOMER_GREETINGS.length)];
        } else if (num == 4) {
            selectedChoice = CUSTOMER_NAME_GREETINGS[rand.nextInt(CUSTOMER_NAME_GREETINGS.length)];
        }else if (num == 5) {
            selectedChoice = programmerGreetings[rand.nextInt(programmerGreetings.length)];
        }else if (num == 6) {
            selectedChoice = wrongInputGreetings[rand.nextInt(wrongInputGreetings.length)];
        }else if (num == 7) {
            selectedChoice = insufficientFundsGreetings[rand.nextInt(insufficientFundsGreetings.length)];
        }else if (num == 8) {
            selectedChoice = ENTER_MONEY[rand.nextInt(ENTER_MONEY.length)];
        }

        return selectedChoice;
    }


    public String input(String str){;
        System.out.println(str);
        return scanner.nextLine();
    }

    public String input(int num){
        printRandomChoice(num);
        return scanner.nextLine();
    }

    public int inputGetInt(String message) {
        while (true) {
            displayMessage(message);
            try{return Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NullPointerException | NumberFormatException exception) {
                displayMessage("You have entered an invalid number." +
                        "\n Please try again");
            }
        }
    }



    public String displayMenuOptions(String[] array, String message){
        return input(iterCreateMenu(array, message));
    }

}
