package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {
	public static double convertToDouble(Scanner scanner){
//		text
		String error_None_Int = "Sorry the input received is not a number. \n" +
				"Please try again using a valid number. ";

		String element = scanner.nextLine();
		Double number;

		while(true){
			try {
				number = Double.parseDouble(element);
				break;
			}
			catch (NumberFormatException ex){
				System.out.println(ex);
				System.out.println(error_None_Int);
				element = scanner.nextLine();
			};
		};
		return number;
	};

	public static void main(String[] args) {
//		Greeting
		String welcome = "Welcome to the program\n";
		String goal = "The goal of this program is to calculate change\n";
		String whole_Greeting = welcome + goal;

//		Questions
		String amount_Bill = "Please enter the amount of the bill:\n";
		String amount_Tendered = "Please enter the amount tendered: ";


		//Error Strings
		String input_R = "Sorry the input received";
		String invalid = 	"\nis not a valid input.\n";
		String try_Again = 	"Please try again using a valid parameter. ";

		System.out.println(whole_Greeting);
		Scanner scanner = new Scanner(System.in);
		double result;

		while (true) {
			System.out.println(amount_Bill);
			double bill = convertToDouble(scanner);

			System.out.println(amount_Tendered);
			double tendered = convertToDouble(scanner);

			result = tendered - bill;
			if(result < 0){
				System.out.println("Sorry but it appears the bill and the tendered amount may be incorrect");
				System.out.println("Please try again entering the number. ");
			} else {
				break;
			}
		}

		System.out.println("The change required is: " + result);

	}

}
