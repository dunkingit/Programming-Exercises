package com.techelevator;

import java.util.Scanner;

public class TempConvert {
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
		String c_Formula = " - 32 / 1.8";
		String f_Formula = " x 1.8 + 32";
		String welcome = "Welcome to the program\n";
		String c = "Celsius";
		String f = "Fahrenheit";

		String goal = "The goal of this program is to\n" +
				"convert: ["+ c + "] -> ["+ f +"]" +
				"\nOR\n"+
				"convert: ["+ f + "] -> ["+ c +"]\n";

		String selection = "Please type 'c' or 'f' to convert your number to that measurement system\n";
		String request_Input = "Please input your desired starting number. ";

		//Error Strings
		String input_R = "Sorry the input received";
		String invalid = 	"\nis not a valid input.\n";
		String try_Again = 	"Please try again using a valid parameter. ";



		String whole_Greeting = welcome + goal + selection;
		System.out.println(whole_Greeting);

		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();

		while(true){
			if(choice.equals("c") || choice.equals("f")){
				break;
			}
			System.out.println(input_R+ "\n--> " + choice + invalid + try_Again + "\n" + selection);
			choice = scanner.nextLine();
		}

		System.out.println(request_Input);

		double number_Choice = convertToDouble(scanner);

		if (choice.equals("c")){
			double result = (number_Choice - 32) / 1.8;
			System.out.println("Your number " + number_Choice + c_Formula + " = " + result + " " + c);
		}

		if (choice.equals("f")){
			double result = number_Choice * 1.8 + 32;
			System.out.println("Your number " + number_Choice + f_Formula + " = " + result + " " + f);
		}

	}

}
