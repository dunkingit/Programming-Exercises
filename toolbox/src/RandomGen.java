import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomGen {
    private final int ITEMS_PER_TYPE = 25;
    private final int ITEMS_PER_ROW = 5;
    private final String[] ITEMTYPES = {"CH", "LI", "HC", "SR"};
    private final String[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".split("");
    private final List<String> itemIdLetters = new ArrayList<>();
    private final List<String> itemIds = new ArrayList<>();
    private final Random random = new Random();
    private final List<String> names = new ArrayList<>();
    private final Map<String, Item> itemMap = new HashMap<>();
    private final List<String> randomNumbers = new ArrayList<>();

    public void fillit(int increment, int start, int end) {
        for (int i = 0; i < ITEMTYPES.length; i++) {
            String letter = getRandomLetterAndCheckListForLetter();
            for (int j = 1; j < ITEMS_PER_ROW + 1; j++) {
                randomNumbers.add(String.valueOf(createNumberNotInList(start, end)));
                itemIds.add(letter + j);
            }
            start = end;
            end += increment;
        }

        System.out.println(randomNumbers);
        System.out.println(itemIds);
    }

    public int createNumberNotInList(int start, int end) {
        int num = random.nextInt(start, end);
        return !randomNumbers.contains(String.valueOf(num)) ? num : createNumberNotInList(start, end);
    }

    public String RandomLetter() {
        return CHARACTERS[random.nextInt(CHARACTERS.length)];
    }

    public String getRandomLetterAndCheckListForLetter() {
        String letter = RandomLetter();
        return !itemIds.contains(letter) ? letter : getRandomLetterAndCheckListForLetter();
    }

    private void createAndAddItem(String type, String letter, int index) {
        String name = names.get(index);
        String itemId = letter;
        double price = random.nextInt(3) * random.nextDouble();
        String hasWrapper = random.nextBoolean() ? "Y" : "N";
        int inventoryQuantity = random.nextInt(101);
        String formattedOutput = String.format("%s %-5s %-25s $%-5.2f %s %d",
                type, itemId, name, price, hasWrapper, inventoryQuantity);
        System.out.println(formattedOutput);
    }

    public void fillItemIdListWithRandomLetterAndNumbers() {
        for (int i = 0; i < ITEMTYPES.length; i++) {
            String letter = getRandomLetterAndCheckListForLetter();
            for (int j = 0; j < ITEMS_PER_ROW; j++) {
                itemIds.add(letter + j);
            }
        }
    }
}




//public class RandomGen {
//    private final int ITEMS_PER_TYPE = 25;
//    private final int ITEMS_PER_ROW = 5;
//    private final String[] ITEMTYPES = {"CH", "LI", "HC", "SR"};
//    private final String[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".split("");
//    private final List<String> itemIdLetters = new ArrayList<>();
//    private final List<String> itemIds = new ArrayList<>();
//
//    private final int[] interval = {0, 25, 50, 75, 100};
//    private final Random random = new Random();
//    private final List<String> names = new ArrayList<>();
//    private final Map<String, Item> itemMap = new HashMap<>();
//    private final List<String> randomNumbers = new ArrayList<>();
//
////    public RandomGen() {
////        readFromRandomCSV();
////    }
//
//    public void goFullRandom(){
//        int start = 0;
//        int end = 25;
//        fillItemIdLetters();
//        for (int i = 0; i < 4; i++) {
//            int counter = 0;
//            while(counter < 5){
//                int ran = random.nextInt(start, end);
//                if(!randomNumbers.contains(String.valueOf(ran))){
//                    randomNumbers.add(String.valueOf(ran));
//                    counter++;
//                }
//            }
//            start += 25;
//            end += 25;
//        }
//    }
//
//    public List<String> getRandomNumbers() {
//        return randomNumbers;
//    }
//
//    public String RandomLetter(){
//        return CHARACTERS[random.nextInt(CHARACTERS.length)];
//    }
//
//    public void addLetterToItemIdLetters(){
//        String letter = RandomLetter();
//        if(itemIdLetters.contains(letter)){
//            addLetterToItemIdLetters();
//        }else{itemIdLetters.add(letter);}
//    }
//
//    public void fillItemIdLetters(){
//        for (int i = 0; i < ITEMTYPES.length ; i++) {
//            addLetterToItemIdLetters();
//            for (int j = 0; j < ITEMS_PER_ROW; j++) {
//                itemIds.add(itemIdLetters.get(i) + j);
//            }
//        }
//    }
//
//    private boolean checkLetterRepeat(int[] checkList, int num){
//        for (int each: checkList) {
//            if(each == num ){return false;}
//        } return true;};
//
//    public boolean placeNumberInRandomNumbers(int num){
//        boolean placeNum = false;
//        if(!randomNumbers.contains(String.valueOf(num))){
//            placeNum = true;
//            randomNumbers.add(String.valueOf(num));
//        }
//        return placeNum;
//    }
//
//    private int[] selectRandomNumbersInRange(int start, int end, int num_of_num) {
//        Set<Integer> uniqueNumbers = new HashSet<>();
//        while (uniqueNumbers.size() < num_of_num) {
//            uniqueNumbers.add(random.nextInt(start, end));
//        }
//        return uniqueNumbers.stream().mapToInt(i -> i).toArray();
//    }
//
//    public int[] fillIntArray(Set<Integer> uniqueArray, int size){
//        if(uniqueArray.size() == size){
//            int[] uniqueNumberIntArray = new int[size];
//            int counter = 0;
//            for (int each :uniqueArray) {
//                uniqueNumberIntArray[counter] = each;
//                counter++;
//            }
//            return uniqueNumberIntArray;
//        }else {return new int[]{};}
//    }

//    private void readFromRandomCSV() {
//        try (Scanner inputScanner = new Scanner(new File("Random.csv"))) {
//            while (inputScanner.hasNextLine()) {
//                names.add(inputScanner.nextLine());}
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();}
//    }

//    public void generateRandomItems() {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            int startRange = i * ITEMS_PER_TYPE;
//            int endRange = startRange + ITEMS_PER_TYPE - 1;
//            int[] selectedIndices = selectRandomNumbersInRange(startRange, endRange);
//            for (int selectedIndex : selectedIndices) {
//                createAndAddItem(ITEMTYPES[i], selectedIndex);
//            }
//        }
//    }
//
//    public void addSingleRandomItem() {
//        int randomTypeIndex = random.nextInt(ITEMTYPES.length);
//        String randomType = ITEMTYPES[randomTypeIndex];
//        int startRange = randomTypeIndex * ITEMS_PER_TYPE;
//        int endRange = startRange + ITEMS_PER_TYPE - 1;
//        int randomItemIndex = random.nextInt(endRange - startRange + 1) + startRange;
//        createAndAddItem(randomType, randomItemIndex);
//    }

//    private void createAndAddItem(String type, String letter, int index) {
//        String name = names.get(index);
//        String itemId = letter;
//        double price = random.nextInt(3) * random.nextDouble();
//        String hasWrapper = random.nextBoolean() ? "Y" : "N";
//        int inventoryQuantity = random.nextInt(101);
//        String formattedOutput = String.format("%s %-5s %-25s $%-5.2f %s %d",
//                type, itemId, name, price, hasWrapper, inventoryQuantity);
//        System.out.println(formattedOutput);
//    }
//}

//public class RandomGen {
//    private static final int MAX_ITEMS_PER_TYPE = 5;
//    private static final String[] ITEMTYPES = {"CH", "LI", "HC", "SR"};
//    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//    private final Random random = new Random();
//    private final List<String> names = new ArrayList<>();
//
//
//    public RandomGen() {
//        readFromRandomCSV();
//        generateItems();
//    }
//
//    private void readFromRandomCSV() {
//        try (Scanner inputScanner = new Scanner(new File("Random.csv"))) {
//            while (inputScanner.hasNextLine()) {
//                names.add(inputScanner.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<Integer> selectRandomIndices(int typeIndex) {
//        Set<Integer> uniqueIndices = new HashSet<>();
//
//        while (uniqueIndices.size() < MAX_ITEMS_PER_TYPE) {
//            int rangeStart = typeIndex * MAX_ITEMS_PER_TYPE;
//            uniqueIndices.add(random.nextInt(MAX_ITEMS_PER_TYPE) + rangeStart);
//        }
//
//        List<Integer> sortedIndices = new ArrayList<>(uniqueIndices);
//        Collections.sort(sortedIndices);
//
//        return sortedIndices;
//    }
//
//    private void generateItems() {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            char letter = CHARACTERS.charAt(i); // To get unique letter for each item type
//
//            List<Integer> selectedIndices = selectRandomIndices(i);
//
//            for (int j = 0; j < selectedIndices.size(); j++) {
//                int selectedIndex = selectedIndices.get(j);
//                createAndStoreItem(ITEMTYPES[i], letter, j + 1, selectedIndex);
//            }
//        }
//    }
//
//    private void createAndStoreItem(String type, char letter, int idNumber, int selectedIndex) {
//        String name = names.get(selectedIndex);
//        String itemId = String.valueOf(letter) + idNumber;
//        double price = 3 * random.nextDouble();
//        String hasWrapper = random.nextBoolean() ? "Y" : "N";
//        int inventoryQuantity = random.nextInt(101);
//
//        // Create appropriate item based on type and store in the map
//        if ("CH".equals(type)) {
//            itemMap.put(itemId, new CH(type, itemId, name, hasWrapper, price, inventoryQuantity));
//        } else if ("LI".equals(type)) {
//            itemMap.put(itemId, new LI(type, itemId, name, hasWrapper, price, inventoryQuantity));
//        } else if ("HC".equals(type)) {
//            itemMap.put(itemId, new HC(type, itemId, name, hasWrapper, price, inventoryQuantity));
//        } else if ("SR".equals(type)) {
//            itemMap.put(itemId, new SR(type, itemId, name, hasWrapper, price, inventoryQuantity));
//        } else {
//            throw new IllegalArgumentException("Invalid type: " + type);
//        }
//    }
//
//    public Map<String, Item> getItemMap() {
//        return itemMap;
//    }
//public void testRandomGeneration() {
//        System.out.println("Testing generation of random items for each type...");
//        generateRandomItems();
//
//        System.out.println("\nTesting addition of a single random item...");
//        addSingleRandomItem();
//    }

//
//    public String getRandomLetterAndCheckListForLetter() {
//        String letter = RandomLetter();
//        return itemIdLetters.contains(letter) ? letter : getRandomLetterAndCheckListForLetter();
//    }
