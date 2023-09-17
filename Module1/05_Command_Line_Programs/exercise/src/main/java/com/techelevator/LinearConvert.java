package com.techelevator;

import java.util.Scanner;

public class LinearConvert {
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
		final double m = 0.3048;
		final double f = 3.2808399;
		String welcome = "Welcome to the program";

		String goal = "The goal of this program is to\n" +
				"convert: [Meters] -> [Feet]" +
				"\nOR\n"+
				"convert: [Feet] -> [Meters]";

		String selection = "Please type 'm' or 'f' to convert your number to that measurement system";
		String request_Input = "Please input your desired starting number. ";

		//Error Strings
		String input_R = "Sorry the input received";
		String invalid = 	"\nis not a valid input.\n";
		String try_Again = 	"Please try again using a valid parameter. ";
		String sc = "Successful";

		Scanner scanner = new Scanner(System.in);

		System.out.println(welcome);
		System.out.println(goal);
		System.out.println(selection);
		String choice = scanner.nextLine();

		while(true){
			if(choice.equals("m") || choice.equals("f")){
				break;
			}
			System.out.println(input_R+ "\n--> " + choice + invalid + try_Again);
			choice = scanner.nextLine();
		}

		System.out.println(request_Input);
		double number_Choice = convertToDouble(scanner);

		if (choice.equals("m")){
			double num = number_Choice * m;
			int result = (int) num;
			System.out.println("Your number " + number_Choice + " x " + m + " = " + result + " Meters");
		}

		if (choice.equals("f")){
			double num = number_Choice * f;
			int result = (int) num;
			System.out.println("Your number " + number_Choice + " x " + f + " = " + result + " Feet");
		}
	}

}
