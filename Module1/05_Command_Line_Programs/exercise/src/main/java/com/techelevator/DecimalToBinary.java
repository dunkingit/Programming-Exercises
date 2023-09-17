package com.techelevator;
import java.util.Scanner;

public class DecimalToBinary {
	public static void main(String[] args) {
		String welcome = "Welcome to the program. ";
		String request_Number = "Please enter a number to turn into a binary number";
		Scanner scanner = new Scanner(System.in);
		StringBuilder text = new StringBuilder();

		System.out.println(welcome);
		System.out.println(request_Number);
		int counter = Integer.parseInt(scanner.nextLine());

		while (counter != 0) {
			text.append(counter % 2 ==1? 1:0);
			counter /= 2;
		}
		text.append("0");
		text.reverse();
		System.out.println(text);

	}

}