package com.techelevator;
import java.util.Scanner;

public class DecimalToBinary {

	public static int convertToInt(Scanner scanner){
		String element = scanner.nextLine();
		while(true){
			try {
				return Integer.parseInt(element);
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
		String invalid = 	"\nis not a valid" + choice + ".\n";
		String tryAgain = 	"Please try again using a valid " + choice;
		System.out.println(inputR+ "\n--> " + input + invalid + tryAgain);
	}

	public static void welcome(){
		String welcome = "Welcome to the program. ";
		String requestUserInput = "Please enter a integer to convert into a binary number";
		String whole_Greeting = welcome + requestUserInput;
		System.out.println(whole_Greeting);
	}

	public static void main(String[] args) {
		welcome();
		Scanner scanner = new Scanner(System.in);
		StringBuilder text = new StringBuilder();
		int userNumber = convertToInt(scanner);

		while (userNumber != 0) {
			text.append(userNumber % 2 ==1? 1:0);
			userNumber /= 2;
		}

		text.append("0");
		text.reverse();
		System.out.println(text);

	}

}