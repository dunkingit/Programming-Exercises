package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieRental rental = new MovieRental("Cars", "VHS", true);
		System.out.println(rental.toString());
		List<MovieRental> MovieRentalList = new ArrayList<>();
		List<String[]> csvList = new ArrayList<>();
		File file = new File("MovieInput.csv");
		try(Scanner reader = new Scanner(file)){
			while(reader.hasNextLine()){
				String[] movieList = reader.nextLine().split(",");
				csvList.add(movieList);
			}

		}catch (FileNotFoundException nofile){
			System.err.println("File not found" + nofile);

		}

		for(String[] each: csvList){
			MovieRentalList.add(new MovieRental(each[0], each[1], each[2].equals("true")));
		}

		for(MovieRental movie: MovieRentalList){
			System.out.println(movie.toString());
		}
	}

}
