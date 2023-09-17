package com.techelevator;

import java.util.Scanner;

public class TempConvert {
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

	public static String userio(Scanner scanner) {

		String userInput = scanner.nextLine();
		while(true){
			if(userInput.equals("c") || userInput.equals("f")){
				return userInput;
			}
			retry(" parameter of 'c' or 'f'", userInput);
			userInput = scanner.nextLine();
		}
	}


	public static void welcome(){
		String c = "Celsius";
		String f = "Fahrenheit";
		String welcome = "Welcome to the program\n";
		String goal = "The goal of this program is to\n" +
				"convert: ["+ c + "] -> ["+ f +"]" +
				"\nOR\n"+
				"convert: ["+ f + "] -> ["+ c +"]\n";

		String selection = "Please type 'c' or 'f' to convert your number to that measurement system\n";
		String wholeGreeting = welcome + goal + selection;
		System.out.println(wholeGreeting);
	}



	public static void main(String[] args) {
		String c = "Celsius";
		String f = "Fahrenheit";
		String cFormula = " - 32 / 1.8";
		String fFormula = " x 1.8 + 32";

		welcome();

		Scanner scanner = new Scanner(System.in);
		String userInput = userio(scanner);
		
		System.out.println("Please input your desired starting number. ");
		double numberChoice = convertToDouble(scanner);
		if (userInput.equals("c")){
			double result = (numberChoice - 32) / 1.8;
			System.out.println("Your number " + numberChoice + cFormula + " = " + result + " " + c);
		}

		if (userInput.equals("f")){
			double result = numberChoice * 1.8 + 32;
			System.out.println("Your number " + numberChoice + fFormula + " = " + result + " " + f);
		}

	}

}
