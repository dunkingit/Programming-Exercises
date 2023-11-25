package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[]{new Cow(), new Chicken(), new Pig()};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		List<Singable> singableList = new ArrayList<>();
		singableList.add(new Tractor());
		singableList.add(new Chicken());
		singableList.add(new Cow());

		for(Singable currentSingable : singableList){
			System.out.println(currentSingable.getName());

		}

		Tractor tractor = (Tractor) singableList.get(0);
		System.out.println("printing tractor remaining gas " + tractor.remainingGallonsGas());
		//System.out.println("printing singable at index 0 remaining gas" + singableList.get(0).remainingGallonsGas());
		System.out.println(singableList.get(0).getName());
	}

}