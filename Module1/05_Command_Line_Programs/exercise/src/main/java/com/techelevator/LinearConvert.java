package com.techelevator;

import java.util.Scanner;

public class LinearConvert {
	public static double convertToDouble(Scanner scanner){
		String element = scanner.nextLine();
		while(true){
			try {
				return Double.parseDouble(element);
			}
			catch (NumberFormatException ex){
				System.out.println(ex);
				retry("number", element);
				element = scanner.nextLine();
			};
		}
	};

	public static void retry(String choice, String input){
		//Error Strings
		String inputR = "Sorry the input received";
		String invalid = 	"\nis not a valid " + choice + ".\n";
		String tryAgain = 	"Please try again using a valid " + choice;
		System.out.println(inputR+ "\n--> " + input + invalid + tryAgain);
	}

	public static void welcome(){
		String welcome = "Welcome to the program";
		String goal = "The goal of this program is to\n" +
				"convert: [Meters] -> [Feet]" +
				"\nOR\n" +
				"convert: [Feet] -> [Meters]";
		String selection = "Please type 'm' or 'f' to convert your number to that measurement system";
		System.out.println(welcome);
		System.out.println(goal);
		System.out.println(selection);

	}


	public static void main(String[] args) {
		final double m = 0.3048;
		final double f = 3.2808399;

		welcome();

		Scanner scanner = new Scanner(System.in);
		String inputEntry = scanner.nextLine();
		while(true){
			if(inputEntry.equals("m") || inputEntry.equals("f")){
				break;
			}
			retry(" parameter of: 'm' or 'f'", inputEntry);
			inputEntry = scanner.nextLine();
		}
		String requestInput = "Please input your desired starting number. ";
		System.out.println(requestInput);
		double numberChoice = convertToDouble(scanner);

		if (inputEntry.equals("m")){
			double num = numberChoice * m;
			int result = (int) num;
			System.out.println("Your number " + numberChoice + " x " + m + " = " + result + " Meters");
		}

		if (inputEntry.equals("f")){
			double num = numberChoice * f;
			int result = (int) num;
			System.out.println("Your number " + numberChoice + " x " + f + " = " + result + " Feet");
		}
	}

}
