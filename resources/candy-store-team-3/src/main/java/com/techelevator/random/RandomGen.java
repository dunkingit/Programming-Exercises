package com.techelevator.random;
import com.techelevator.items.*;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGen extends RandomUtility {
    private Map<String, Item> inventoryMap = new HashMap<>();
    private final int MAX_NAMES = 100;
    private final int ITEMS_PER_TYPE_IN_CSV = 25;
    private int increment = ITEMS_PER_TYPE_IN_CSV;
    private int numOfItems = 20;
    private final String[] ITEM_TYPES = {"CH", "LI", "HC", "SR"};
    public static final Random random = new Random();
    private final List<String> names;
    private int start = 0;
    private int end = 25;
    private final List<String> itemIds = new ArrayList<>();
    private final List<Integer> randomNumbers = new ArrayList<>();
    private List<String[]> listsOfItemsAsStrings = new ArrayList<>();
    private int itemNum = 0;

    public RandomGen(int numOfItems, List<String> listOfNames ) {
        if (numOfItems > 0 && numOfItems <= MAX_NAMES) {
            this.numOfItems = numOfItems;
        } else if (numOfItems < 0) {
            System.out.println("Negative entry. Will default to 20");
        } else {
            System.out.println("We're sorry but you've exceeded our candy limit! Defaulting to 100.");
            this.numOfItems = MAX_NAMES;
        }
        this.names = listOfNames;
    }

    public int getITEMS_PER_ROW() {
        return numOfItems / ITEM_TYPES.length;
    }


    public void generateRandomItemsFullAuto() {
        for (int i = 0; i < ITEM_TYPES.length; i++) {
            String letter = randomLetterNotInList();
            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
                int newNumber = createNumberNotInIntegerList(start, end, randomNumbers);
                randomNumbers.add(newNumber);
                itemIds.add(letter + j);
                String[] array = createStringArrayOfItem(letter + j, ITEM_TYPES[i], newNumber);
                listsOfItemsAsStrings.add(array);
            }
            this.start = this.end;
            this.end += this.increment;
        }
    }

    public void fillRandomIds() {
        for (int i = 0; i < ITEM_TYPES.length; i++) {
            String letter = randomLetterNotInList();
            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
                itemIds.add(letter + j);
            }
        }
    }

    public void fillRandomNumbers(int increment, int start, int end) {
        for (int i = 0; i < ITEM_TYPES.length; i++) {
            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
                int newNumber = createNumberNotInIntegerList(start, end, randomNumbers);
                randomNumbers.add(newNumber);
            }
            start = end;
            end += increment;
        }

    }

    public List<String[]> getListsOfItemsAsStrings() {
        return listsOfItemsAsStrings;
    }

    public String randomLetterNotInList() {
        String letter = RandomLetter();
        return !itemIds.contains(letter) ? letter : randomLetterNotInList();
    }

    private String[] createStringArrayOfItem(String itemId, String type, int randomNumber) {
        String name = names.get(randomNumber);
        double price = 3 * random.nextDouble();
        String hasWrapper = random.nextBoolean() ? "Y" : "N";
        int inventoryQuantity = random.nextInt(101);
        return new String[] {type, itemId, name, Double.toString(price), hasWrapper, Integer.toString(inventoryQuantity)};
    }
}
