package com.techelevator;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public String input(String message){
		System.out.println(message);
		return userInput.nextLine();
	}

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		try(BufferedWriter addTo = new BufferedWriter
				(new FileWriter( input("What is the destination file?" ), true) ) ){
		for (int i = 1; i < 301; i++) {
		addTo.append(
				i % 3 == 0 && i % 5 == 0? "FizzBuzz":
				i % 3 == 0? "Fizz":
				i % 5 == 0? "Buzz":
				String.valueOf(i)).append('\n');
		}
		} catch (IOException e)
		{throw new RuntimeException(e);}

    }

}
