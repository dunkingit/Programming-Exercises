package com.techelevator;
import java.util.Scanner;

public class Fibonacci {

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
		String invalid = 	"\nis not a valid " + choice + ".\n";
		String tryAgain = 	"Please try again using a valid " + choice;
		System.out.println(inputR+ "\n--> " + input + invalid + tryAgain);
	}

	public static void welcome(){
		String welcome = "Welcome to the program";
		String goal = "The goal of this program is to get the fibonacci numbers up to the " +
				"specified numbers";
		String requestInput = "Please input your desired starting number. ";
		System.out.println(welcome);
		System.out.println(goal);
		System.out.println(requestInput);
	}

	public static void main(String[] args) {
		welcome();
		String listOfFibNumbers = "0,1";
		Scanner scanner = new Scanner(System.in);
		int numberChoice = convertToInt(scanner);

		for (int i = 0; i < numberChoice; i++) {
			String[] newArray = listOfFibNumbers.split(",");
			int lastElement = Integer.parseInt(newArray[newArray.length - 1]);
			int beforeLastElement = Integer.parseInt(newArray[newArray.length - 2]);
			i = beforeLastElement + lastElement;
			if(i > numberChoice){
				break;
			}
			System.out.println(beforeLastElement + " + " + lastElement + " = " + i);
			listOfFibNumbers += "," + i;
		}
		System.out.println("\n-----Fibonacci-----");
		System.out.println(listOfFibNumbers);
	}

}
