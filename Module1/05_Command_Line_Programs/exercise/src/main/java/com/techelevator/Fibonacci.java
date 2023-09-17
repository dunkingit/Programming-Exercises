package com.techelevator;
import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static int convert_To_Int(String element){
//		text
		String error_None_Int = "Sorry the input received is not a number. \n" +
				"Please try again using a valid number. ";
		String sc = "Successfully made int. ";

		int number;

		while(true){
			try {
				number = Integer.parseInt(element);
				break;
			}
			catch (NumberFormatException ex){
				System.out.println(ex);
				System.out.println(error_None_Int);
				Scanner scanner = new Scanner(System.in);
				element = scanner.nextLine();
			};
		};

		return number;
	};

	public static void main(String[] args) {
		String welcome = "Welcome to the program";
		String goal = "The goal of this program is to get the fibonacci numbers up to the " +
				"specified numbers";
		String request_Input = "Please input your desired starting number. ";
		String fib_Numbers = "0,1";

		System.out.println(welcome);
		System.out.println(goal);
		System.out.println(request_Input);

		Scanner scanner = new Scanner(System.in);
		int number_Choice = convert_To_Int(scanner.nextLine());

		for (int i = 0; i < number_Choice; i++) {
			String[] newArray = fib_Numbers.split(",");
			int last = convert_To_Int(newArray[newArray.length - 1]);
			int before_Last = convert_To_Int(newArray[newArray.length - 2]);
			i = before_Last + last;
			if(i > number_Choice){
				break;
			}
			System.out.println(before_Last + " + " + last + " = " + i);
			fib_Numbers += "," + i;
		}
		System.out.println("\n-----Fibonacci-----");
		System.out.println(fib_Numbers);
	}

}
