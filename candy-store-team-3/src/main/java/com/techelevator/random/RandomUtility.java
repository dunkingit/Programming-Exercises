package com.techelevator.random;

import java.util.List;
import java.util.Random;

import static com.techelevator.random.RandomGen.random;

public class RandomUtility {
    private static final String[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".split("");

    public String RandomLetter() {
        return CHARACTERS[random.nextInt(CHARACTERS.length)];
    }

    public void randomOuterInnerLoop(int outsideLoop, int insideLoop, String input, String input2) {
        for (int i = 0; i <  insideLoop; i++) {
            String outerString = input;
            for (int j = 1; j < outsideLoop; j++) {
//                itemIds.add(letter + j);
                String innerString = input2;
            }
        }
    }

    public int createNumberNotInIntegerList(int start, int end, List<Integer> alist) {
        int num;
        while(true) {
            num = random.nextInt(end);
            boolean condition1 = !alist.contains(String.valueOf(num));
            boolean condition2 = num >= start && num <= end;
            if(condition1 && condition2){
                break;
            }
        }
        return num;
    }

    public int createNumberNotInStringList(int start, int end, List<String> alist) {
        int num;
        while(true) {
            num = random.nextInt(end);
            boolean condition1 = !alist.contains(num);
            boolean condition2 = num >= start && num <= end;
            if(condition1 && condition2){
                break;
            }
        }
        return num;
    }

    // For List of String
    public boolean containsMatch(List<String> list, String match) {
        return list.contains(match);
    }

    // For List of Integer
    public boolean containsMatch(List<Integer> list, int match) {
        return list.contains(match);
    }

    // For array of String
    public boolean containsMatch(String[] array, String match) {
        for (String item : array) {
            if (item.equals(match)) {
                return true;
            }
        }
        return false;
    }

    // For array of int
    public boolean containsMatch(int[] array, int match) {
        for (int item : array) {
            if (item == match) {
                return true;
            }
        }
        return false;
    }

    public int generateRandomIntBetween(int lower, int upper) {
        Random random = new Random();
        int result;

        while (true) {
            result = random.nextInt(upper + 1); // upper + 1 because nextInt is exclusive for the upper bound
            if (result >= lower) {
                return result;
            }
        }

    }
}
