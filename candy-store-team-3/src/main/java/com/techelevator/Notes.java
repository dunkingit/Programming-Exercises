package com.techelevator;

public class Notes {}

//    Make Item Abstract:
//    This will serve as the base class for the various types of items.
//
//    Remove the type field from Item:
//    Since the type will be represented by the subclass, we don't need a type field in the Item class anymore.
//
//    Create Subclasses:
//    Create subclasses for each type of item
//    (e.g., ChocolateConfectionery, SourFlavored, HardTackConfectionery, LicoriceAndJellies).
//

//    public abstract class Item {
//
//        private String itemID;
//        private String name;
//        private boolean hasWrapper;
//        private int quantity = 100;
//        private double price;
//
//        //... Constructors, Getters and Setters remain unchanged ...
//    }
//
//    public class ChocolateConfectionery extends Item {
//        // Any specific fields or methods for ChocolateConfectionery
//
//        public ChocolateConfectionery(String itemID, String name, boolean hasWrapper, int quantity, double price) {
//            super(itemID, name, hasWrapper, quantity, price);
//        }
//    }
//
//    public class SourFlavored extends Item {
//        // Any specific fields or methods for SourFlavored
//
//        public SourFlavored(String itemID, String name, boolean hasWrapper, int quantity, double price) {
//            super(itemID, name, hasWrapper, quantity, price);
//        }
//    }


 //   String currentLineFromFile = inputScanner.nextLine();
//                String[] currentLineArray = currentLineFromFile.split("\\|");
//                String type = currentLineArray[0];
//                String itemId = currentLineArray[1];
//                String name = currentLineArray[2];
//                double price = Double.parseDouble(currentLineArray[3]);
//                boolean hasWrapper = true;
//                if(currentLineArray[4].equals("F")){
//                    hasWrapper = false;
//                };
//
//                Item item = null;
//
//                //what to do with the type
//                item.setItemID(itemId);
//                item.setName(name);
//                item.setType(type);
//                item.setHasWrapper(hasWrapper);
//                item.setPrice(price);
//                inventoryMap.put(itemId, item);
//                System.out.println(currentLineArray[0]);
//    public int transferFunds(BankAccount destinationAccount, int transferAmount){
//        //Withdraws transferAmount from this account and deposits it into destinationAccount.
//        // Returns the new balance of the "from" account.
//
//        this.withdraw(transferAmount);
//        destinationAccount.deposit(transferAmount);
//        return this.balance;
//    };

//        while (true) {
//            int intInput = amenu.userInputInt("Please enter the (number) amount you wish to purchase:");
//            currentItem.setQuantity(currentItem.getQuantity() - intInput);
//
//            for (int i = 0; i < intInput; i++) {
//                this.shoppingCart.add(currentItem);
//            }
//
//            currentCart(ifReader.getInventoryMap());
//            break;
//        }



//    public Map<String, Integer> cartCount(){
//        cartMap = new HashMap<>();
//        for(Item each : shoppingCart){
//            if (!cartMap.containsKey(each.getItemID())) {
//                cartMap.put(each.getItemID(), 1);
//            } else {
//                cartMap.put(each.getItemID(),cartMap.get(each.getItemID()) + 1);
//            }
//        }
//        return cartMap;
//    }

//    public void currentCart(Map<String, Item> dict){
//        cartCount();
//        for(Map.Entry<String, Integer>  each: cartMap.entrySet()){
//            String invItem = String.format("%-10s  %-15s  %-7s  %-7s  $%.2f",
//                    each.getValue(),
//                    dict.get(each.getKey()).getName(),
//                    dict.get(each.getKey()).getDesc(),
//                    dict.get(each.getKey()).getPrice(),
//                    each.getValue() * dict.get(each.getKey()).getPrice());
//            System.out.println(invItem);
//        }
//    };



//     public String userInputCheckList(String message, Set<String> listCheck, Scanner scanner) {
////        System.out.println(message);
////        try{
////            String input = scanner.nextLine().toUpperCase();
////            if(listCheck.contains(input)) {
////                return input;
////            }
////        } catch (NullPointerException | NumberFormatException exception) {
////            System.out.println("You have entered an invalid Id.");
////            System.out.println("Please try again");
////        }
////    }

//    public void displayInventory(Item name){
//        String header = String.format("%-10s  %-15s  %-5s  %-5s  %-5s",
//                "Id", "Name", "Wrapper", "Quantity", "Price");
//
//        String invItem = String.format(
//                "%-10s  %-15s  %-7s  %-7s  $%.2f",
//                name.getItemID(),
//                name.getName(),
//                name.isHasWrapper(),
//                name.getQuantity() > 0 ? name.getQuantity() : "SOLD OUT",
//                name.getPrice());
//        System.out.println(invItem);
//    }
//Version 2
//public class ApplicationCLI {
//
//    private static final String INVENTORY_PATH = "inventory.csv";
//    private static final String LOG_PATH = "log.txt";
//
//    private Menu menu = new Menu();
//    private InventoryFileReader storeClerk;
//    private LogFileWriter toLog;
//    private Scanner scanner = new Scanner(System.in);
//    private CustomerAccount customerAccount = new CustomerAccount();
//    private VenderAccount venderAccount = new VenderAccount();
//    private Cart shoppingCart = new Cart();
//    private Register register;
//
//    public static void main(String[] args) {
//        ApplicationCLI cli = new ApplicationCLI();
//        cli.run();
//    }
//
//    public ApplicationCLI() {
//        storeClerk = new InventoryFileReader(INVENTORY_PATH);
//        toLog = new LogFileWriter(LOG_PATH);
//        register = new Register(customerAccount, venderAccount, shoppingCart);
//    }
//
//    public void run() {
//        storeClerk.stocksInventory();
//        menu.greet();
//
//        while(true) {
//            menu.getDisplayMainMenu();
//            String choice = scanner.nextLine();
//
//            if ("1".equals(choice)) {
//                displayInventory();
//            } else if ("2".equals(choice)) {
//                processSubMenu();
//            } else if ("3".equals(choice)) {
//                System.exit(0);
//            }
//        }
//    }
//
//    private void displayInventory() {
//        StringBuilder mainString = new StringBuilder();
//        storeClerk.displayInventory(mainString);
//    }
//
//    private void processSubMenu() {
//        while (true) {
//            menu.getDisplaySubMenu();
//            register.printBalance();
//            String otherChoice = scanner.nextLine();
//
//            if ("1".equals(otherChoice)) {
//                register.takeMoneyOption(scanner, toLog);
//            } else if ("2".equals(otherChoice)) {
//                purchaseItems();
//            } else if ("3".equals(otherChoice)) {
//                register.checkout();
//            } else if ("4".equals(otherChoice)) {
//                return;  // Break out of the while loop
//            }
//        }
//    }
//
//    private void purchaseItems() {
//        displayInventory();
//        register.printBalance();
//        shoppingCart.getUserSelections(storeClerk, menu, scanner);
//        menu.displayMessage(shoppingCart.currentCart());
//        menu.displayMessage(shoppingCart.cartStatus());
//    }
////}
//
//    public void greet() {
//        System.out.println("╔════════════════════════════════════════════════╗");
//        System.out.println("║  Thank you for choosing our vending machine!   ║");
//        System.out.println("║                                                ║");
//        System.out.println("║   Our system can securely hold up to $1000.    ║");
//        System.out.println("║      You may insert up to $100 at a time.      ║");
//        System.out.println("║                                                ║");
//        System.out.println("║                 WARNING!!!                     ║");
//        System.out.println("║                 NO REFUNDS                     ║");
//        System.out.println("╚════════════════════════════════════════════════╝");
//    }
//
//    public void displayBox(){
//        System.out.println("╔════════════════════════════════════════════════╗");
//        System.out.println("║   How much would you like to deposit today?    ║");
//        System.out.println("╚════════════════════════════════════════════════╝");
//    }
//
//"CH", "SR", "HC", "LI"
// Later 1
//
//    public String setDesc(String type) {
//        if (type.equalsIgnoreCase("CH")) {
//            return "Chocolate Confectionery";
//        }
//        if (type.equalsIgnoreCase("SR")) {
//            return "Sour Flavored";
//        }
//        if (type.equalsIgnoreCase("HC")) {
//            return "Hard Tack Confectionery";
//        }
//        if (type.equalsIgnoreCase("LI")) {
//            return "Licorce and Jellies";
//
//        }
//        return "No Description";
//    }



// old file checker

//    public void checkForFile(){
//        while(!doesFileExist()){}
//    }
//
//    public boolean doesFileExist() {
//            String check = input("Please input the file name: ");
//            File fileObj = new File(check);
//            if (fileObj.exists()) {
//                System.out.println("File name: " + fileObj.getName());
//                System.out.println("Absolute path: " + fileObj.getAbsolutePath());
//                System.out.println("Writeable: " + fileObj.canWrite());
//                System.out.println("Readable " + fileObj.canRead());
//                System.out.println("File size in bytes " + fileObj.length());
//                return true;
//            } else {
//                System.out.println("The file does not exist.");
//            }
//            return false;
//    }


//    public InventoryManagerPopulate(List<Item> items, Menu menu) {
////        for(Item each:items){
////            inventoryMap.put(each.getItemID(), each);
////        }
////        this.menu = menu;
////    }

//    public void takeMoneyOption(Scanner scanner) {
//        while(true) {
//            int enterNumbered = menu.userInputInt("Please insert your money below");
//            if (enterNumbered > 100) {
//                System.out.println("Sorry at this time we can not accept bills over a $100\n" +
//                        "Please try again");
//                continue;
//            }
//            if (enterNumbered + customer.getBalance() > 1000) {
//                System.out.println("We're sorry but depositing that much would exceed the maximum allowance of $1000");
//                continue;
//            }
//            customer.deposit(enterNumbered);
//            break;
//        }
//    }

////// random


//    public void inputNumbersIntoListPerInterval(int increment, int start, int end) {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            String letter = getRandomLetterAndCheckListForLetter();
//            for (int j = 0; j < ITEMS_PER_ROW; j++) {
//                randomNumbers.add(String.valueOf(createNumberNotInList(start, end)));
//                itemIds.add(letter + j);
//            }
//            start = end;
//            end += start;
//        }
//    }
//
//    public int createNumberNotInList(int start, int end) {
//        int num = random.nextInt(start, end);
//        return !randomNumbers.contains(String.valueOf(num)) ? num : createNumberNotInList(start, end);
//    }
//
//    public String RandomLetter() {
//        return CHARACTERS[random.nextInt(CHARACTERS.length)];
//    }
//
//    public String getRandomLetterAndCheckListForLetter() {
//        String letter = RandomLetter();
//        return itemIdLetters.contains(letter) ? letter : getRandomLetterAndCheckListForLetter();
//    }
//
//
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
//
//    public void fillItemIdListWithRandomLetterAndNumbers() {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            String letter = getRandomLetterAndCheckListForLetter();
//            for (int j = 0; j < ITEMS_PER_ROW; j++) {
//                itemIds.add(letter + j);
//            }
//        }
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
//    private boolean checkLetterRepeat(int[] checkList, int num){
//        for (int each: checkList) {
//         if(each == num ){return false;}
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

//Random newer Version
//
//    public void whatit(int increment, int start, int end) {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            String letter = randomLetterNotInList();
//            for (int j = 1; j < ITEMS_PER_ROW + 1; j++) {
//                int newNumber = createNumberNotInList(start, end);
//                randomNumbers.add(String.valueOf(newNumber));
//                itemIds.add(letter + j);
//                createAndAddItem(newNumber, letter +j, ITEMTYPES[i]);
//            }
//            start = end;
//            end += increment;
//        }
//    }
//
//    public int createNumberNotInList(int start, int end) {
//        int num = random.nextInt(start, end);
//        return !randomNumbers.contains(String.valueOf(num)) ? num : createNumberNotInList(start, end);
//    }
//
//    public String RandomLetter() {
//        return CHARACTERS[random.nextInt(CHARACTERS.length)];
//    }
//
//    public String randomLetterNotInList() {
//        String letter = RandomLetter();
//        return !itemIds.contains(letter) ? letter : randomLetterNotInList();
//    }
//
//    private void createAndAddItem(int index, String letter, String type) {
//        String name = names.get(index);
//        String itemId = letter;
//        double price = random.nextInt(3) * random.nextDouble();
//        String hasWrapper = random.nextBoolean() ? "Y" : "N";
//        int inventoryQuantity = random.nextInt(101);
//        String formattedOutput = String.format("%s %-5s %-25s $%-5.2f %s %d",
//                type, itemId, name, price, hasWrapper, inventoryQuantity);
//        System.out.println(formattedOutput);
//    }
//
//    public void fillItemIdListWithRandomLetterAndNumbers() {
//        for (int i = 0; i < ITEMTYPES.length; i++) {
//            String letter = randomLetterNotInList();
//            for (int j = 0; j < ITEMS_PER_ROW; j++) {
//                itemIds.add(letter + j);
//            }
//        }
//    }

//    public void stocksInventory(String[] array) {
//        checkInfo(array);
//
//        Item aitem;
//
//        if ("CH".equals(array[0])) {
//            aitem = new CH(array[0], array[1], array[2],
//                    array[3], checkDouble(array[4]), 100);
//        }
//        else if ("SR".equals(array[0])) {
//            aitem = new SR(array[0], array[1], array[2],
//                    array[3], checkDouble(array[4]), 100);
//        }
//        else if ("HC".equals(array[0])) {
//            aitem = new HC(array[0], array[1], array[2],
//                    array[3], checkDouble(array[4]), 100);
//        }
//
//        else if ("LI".equals(array[0])) {
//            aitem = new LI(array[0], array[1], array[2],
//                    array[3], checkDouble(array[4]), 100);
//        }
//
//        else {
//            throw new IllegalArgumentException("Invalid type: " + array[0]);
//        }
//
//        putIntoInventory(array[1], aitem);
//    }    public String padKey(String key) {
////        // Assuming all keys have a single letter prefix
////        char prefix = key.charAt(0);
////        int number = Integer.parseInt(key.substring(1));
////
////        // Format the number with leading zeros, e.g., "001", "010", "100"
////        String paddedNumber = String.format("%03d", number);
////
////        return prefix + paddedNumber;
////    }

//public class RandomGen {
//    private final int ITEMS_PER_TYPE_IN_CSV = 25;
//    private int increment = ITEMS_PER_TYPE_IN_CSV;
//    private int start = 0;
//    private int end = 25;
//    private int numOfItems = 20;
//    private final String[] ITEM_TYPES = {"CH", "LI", "HC", "SR"};
//    private static final String[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".split("");
//    private final List<String> itemIdLetters = new ArrayList<>();
//    private final List<String> itemIds = new ArrayList<>();
//    private final Random random = new Random();
//    private final List<String> names = new ArrayList<>();
//    private final Map<String, Item> itemMap = new HashMap<>();
//    private final List<String> randomNumbers = new ArrayList<>();
//
//    public int getNumOfItems() {
//        return numOfItems;
//    }
//
//    public String[] getITEM_TYPES() {
//        return ITEM_TYPES;
//    }
//
//    public int getITEMS_PER_ROW() {
//        return numOfItems / ITEM_TYPES.length;
//    }
//
//    public RandomGen() {
//        readFromRandomCSV();
//    }
//
//    public RandomGen(int numOfItems) {
//        if(numOfItems > 0 && numOfItems <= 100) {
//            this.numOfItems = numOfItems;
//        }else if(numOfItems < 0){
//            System.out.println("Negitive entry. Will default to 20");
//            this.numOfItems = 20;
//        }else if(numOfItems > 100){
//            System.out.println("Were sorry but you have put more items than we can spare inside there. " +
//                    "We will default you to 100. Thank you");
//            this.numOfItems = 100;
//        }
//        readFromRandomCSV();
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
//    public void runWholeSequence(){
//        for (int i = 0; i < ITEM_TYPES.length; i++) {
//            String letter = randomLetterNotInList();
//            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
//                int newNumber = createNumberNotInList(this.start, this.end);;
//                randomNumbers.add(String.valueOf(newNumber));
//                itemIds.add(letter + j);
//                createAndAddItem(newNumber, letter +j, ITEM_TYPES[i]);
//            }
//            this.start = this.end;
//            this.end += this.increment;
//        }
//    }
//
//    public void fillRandomIds() {
//        for (int i = 0; i < ITEM_TYPES.length; i++) {
//            String letter = randomLetterNotInList();
//            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
//                itemIds.add(letter + j);
//            }
//        }
//    }
//
//    public void fillRandomNumbers(int increment, int start, int end) {
//        for (int i = 0; i < ITEM_TYPES.length; i++) {
//            for (int j = 1; j < getITEMS_PER_ROW() + 1; j++) {
//                int newNumber = createNumberNotInList(start, end);
//                randomNumbers.add(String.valueOf(newNumber));
//            }
//            start = end;
//            end += increment;
//        }
//
//    }
//
//    public int createNumberNotInList(int start, int end) {
//        int num = random.nextInt(end);
//        boolean condition1 = !randomNumbers.contains(String.valueOf(num));
//        boolean condition2 = num >= start && num <= end;
//        return condition1 && condition2? num:createNumberNotInList(start, end);
//    }
//
//    public String RandomLetter() {
//        return CHARACTERS[random.nextInt(CHARACTERS.length)];
//    }
//
//    public String randomLetterNotInList() {
//        String letter = RandomLetter();
//        return !itemIds.contains(letter) ? letter : randomLetterNotInList();
//    }
//
//    private void createAndAddItem(int index, String letter, String type) {
//        String name = names.get(index);
//        String itemId = letter;
//        double price = 3 * random.nextDouble();
//        String hasWrapper = random.nextBoolean() ? "Y" : "N";
//        int inventoryQuantity = random.nextInt(101);
//        String formattedOutput = String.format("%s %-5s %-25s $%-5.2f %s %d",
//                type, itemId, name, price, hasWrapper, inventoryQuantity);
//        System.out.println(formattedOutput);
//    }
//}



//Other part from

//    public void generateRandomItems() {
//        for (String itemType : ITEM_TYPES) {
//            String letter = randomLetterNotInList(fillRandomIds());
//            List<String> currentRandomNumbers = fillRandomNumbers(ITEMS_PER_TYPE,
//                    (ITEMS_PER_TYPE * Arrays.asList(ITEM_TYPES).indexOf(itemType)),
//                    (ITEMS_PER_TYPE * (Arrays.asList(ITEM_TYPES).indexOf(itemType) + 1)));
//
//            List<Item> itemsForType = new ArrayList<>();
//            for (int j = 0; j < currentRandomNumbers.size(); j++) {
//                itemsForType.add(createItem(letter + (j + 1), itemType, currentRandomNumbers.get(j)));
//            }
//            itemMap.put(itemType, itemsForType);
//        }
//    }
//
//    // Method to generate random item IDs
//    public List<String> fillRandomIds() {
//        List<String> itemIds = new ArrayList<>();
//        for (String itemType : ITEM_TYPES) {
//            String letter = randomLetterNotInList(itemIds);
//            for (int j = 1; j <= ITEMS_PER_TYPE; j++) {
//                itemIds.add(letter + j);
//            }
//        }
//        return itemIds;
//    }
//
//    // Method to generate a list of random numbers
//    public List<String> fillRandomNumbers(int numOfItems, int start, int end) {
//        List<String> randomNumbers = new ArrayList<>();
//        while (randomNumbers.size() < numOfItems) {
//            int newNumber = createNumberNotInList(start, end, randomNumbers);
//            randomNumbers.add(String.valueOf(newNumber));
//        }
//        return randomNumbers;
//    }
//
//    // Method to generate a number not in the existing list
//    public int createNumberNotInList(int start, int end, List<String> existingNumbers) {
//        int num;
//        do {
//            num = random.nextInt(end);
//        } while (existingNumbers.contains(String.valueOf(num)) || num < start);
//        return num;
//    }
//
//    // Helper method to get a random letter
//    public String randomLetter() {
//        return CHARACTERS[random.nextInt(CHARACTERS.length)];
//    }
//
//    // Helper method to get a random letter not in the existing list
//    public String randomLetterNotInList(List<String> existingIds) {
//        String letter;
//        do {
//            letter = randomLetter();
//        } while (existingIds.contains(letter));
//        return letter;
//    }
//		RandomGen ra = new RandomGen();
//		ra.whatit(25, 0, 26);
//		Map<String, Item> itemsMap = generator.getItemMap();
//
//		// Display the items
//		List<String> sortedKeys = new ArrayList<>(itemsMap.keySet());
//		Collections.sort(sortedKeys);
//		for (String key : sortedKeys) {
//			System.out.println(itemsMap.get(key));
//		}

//    public void addIntoCart(Item currentItem, int intInput) {
//        currentItem.setQuantity(currentItem.getQuantity() - intInput);
//        CartItem cartItem = new CartItem(currentItem, intInput);
//        this.shoppingCart.add(cartItem);
//    }

//    static String thanks = "Thank you for shopping with us";
//    static String valid = "\nPlease select a valid option: Please try again. \n";
//    static String funny ="Thank you so much for trusting me with $1000 of your money. \nMy " +
//            "spouse will not even do that. \nGood luck getting a refund. You get what you " +
//            "deserve by putting $1000 into a vending machine. \nGOOD LUCK. ";
//    static String enterNumberForQuantity = "Please enter the (number) amount you wish to purchase:";
//    static String notEnoughProductError = "We're sorry but at this time your request would" +
//            " exceed our current inventory levels. \nPlease try to enter the amount you desire again. Thank you.";
//    static String enteredZeroErrorMessage = "You have seemed to have entered 0 has the number of items you would like. " +
//            "\nPlease try again and enter a number valid number above zero";
//
//    static String askForId = "Please enter the item Id to purchase or x when finished:";
//    static String errorIdNotFound = "We apologize for the inconvience but the item you entered" +
//            " seems to incorrect. \nPlease check your choice and try again.";
//    static String soldOutError = "We're sorry but at this time we are sold out of this product. \n";
//    static String header = String.format("%-10s  %-15s  %-5s  %-5s  %-5s",
//            "Id", "Name", "Wrapper", "Quantity", "Price");
//    static String message1 = "How much would you like to deposit today?";
//    static String message2 = "Our system can securely hold up to $1000.";
//    static String message3 = "You may insert up to $100 at a time. ";
//    static String message4 = "Thank you for choosing our vending machine!";
//    static String choiceOption = "Please select an option: ";
//    static String max = "Maximum attempts reached. Please try again later.";
//    static String iofilename = "Please input the file name (or type 'quit' to exit): ";
//    static final String NEGATIVE_ENTRY_MSG = "Whoops! You went negative. Defaulting to 20 items.";
//    static final String EXCEED_LIMIT_MSG = "Woah there, big spender! Limiting you to 100 items.";
//    static String[] choiceMain = {"Show Inventory", "Make Sale", "Quit"};
//    static String[] choiceSecond = {"Take Money", "Select Products",
//         "Complete Sale", "Return to the Main Menu"};
//    static String select_options = "Please select from the following options:\n";
//public String fullbox(String str, int boxsize){
//        return this.topbox(boxsize) + "\n" +
//                (str.contains("\n")? this.multiCenter(str, boxsize): this.centerbox(str, boxsize)) +
//                this.bottombox(boxsize);
//    }
//
//    public String topbox (int num){
//        return "╔" + "═".repeat(num - 1) + "╗";
//    };
//
//    public String centerbox(String str, int num){
//        int width = num;
//        String s = str;
//        int padSize = width - s.length();
//        int padStart = s.length() + padSize / 2;
////        String bar = "║" + " ".repeat(padSize / 2) + str +  " ".repeat(padSize / 2) + "║";
//        s = String.format("║%" + padStart + "s", s);
//        s = String.format("%-" + width  + "s"+"║", s);
//        return s + "\n";
//    }
//
//    public String bottombox (int num){
//        return "╚" + "═".repeat(num - 1) + "╝";
//    };
//
//    public String multiCenter(String str, int num){
//        String temp = "";
//        for (String each : str.split("\n")){
//            temp+= centerbox(each, num);
//        }
//        return temp;
//
//    }
// Old run method

//	public void run() {
//		String fileChoice = "Random.csv";
//		storeClerkReads = new InventoryFileReader("Inventory.csv");
//		List<String[]> stringlists;
//		if (fileChoice.equals("Random.csv")){
//			List<String> temp = storeClerkReads.stocksAllWithRandomInventory("Random.csv");
//			RandomGen rg = new RandomGen(100, temp);
//			rg.generateRandomItemsFullAuto();
//			stringlists = rg.getListsOfItemsAsStrings();
//		}else{
//			stringlists = storeClerkReads.stocksAllInventory();
//		}
//		storeClerkManagesInventory.iterStringListsPlaceIntoInventory(stringlists);
//		menu.displayMessage(menu.displayBox());
//	}

//	public void run() {
//		String fileChoice = "Random.csv";
//		storeClerkReads = new InventoryFileReader("Inventory.csv");
//		List<String[]> stringlists;
//		if (fileChoice.equals("Random.csv")){
//			List<String> temp = storeClerkReads.stocksAllWithRandomInventory("Random.csv");
//			RandomGen rg = new RandomGen(100, temp);
//			rg.generateRandomItemsFullAuto();
//			stringlists = rg.getListsOfItemsAsStrings();
//		}else{
//			stringlists = storeClerkReads.stocksAllInventory();
//		}
//		storeClerkManagesInventory.iterStringListsPlaceIntoInventory(stringlists);
//		menu.displayMessage(menu.displayBox());
//	}//        if (attempts < MAXATTEMPTS) {
////            attempts++;
////            fileObj = new File(str);
////            if (fileObj.exists()) {
////                return true;
////            } else {
////                System.out.println("File not found! Please try again.");
////                return false;
////            }
////        } else {
////            System.out.println("Maximum attempts reached!");
////            return false;
//// //
////        public void currentCart(Map<String, Item> dict){
////        cartCount();
////        for(Map.Entry<String, Integer>  each: cartMap.entrySet()){
////            String invItem = String.format("%-10s  %-15s  %-7s  %-7s  $%.2f",
////                    each.getValue(),
////                    dict.get(each.getKey()).getName(),
////                    dict.get(each.getKey()).getDesc(),
////                    dict.get(each.getKey()).getPrice(),
////                    each.getValue() * dict.get(each.getKey()).getPrice());
////            System.out.println(invItem);
////        }
////    };
////
////        public void displayInventory(Item name){
////        String header = String.format("%-10s  %-15s  %-5s  %-5s  %-5s",
////                "Id", "Name", "Wrapper", "Quantity", "Price");
////
////            String invItem = String.format(
////                "%-10s  %-15s  %-7s  %-7s  $%.2f",
////                name.getItemID(),
////                name.getName(),
////                name.isHasWrapper(),
////                name.getQuantity() > 0 ? name.getQuantity() : "SOLD OUT",
////                name.getPrice());
////        System.out.println(invItem);
////
////            String formattedOutput = String.format("%s %-5s %-25s $%-5.2f %s %d",
////                type, itemId, name, price, hasWrapper, inventoryQuantity);       }

//private static final int MAXATTEMPTS = 3;
//	int attempts = 0;
//	File fileObj;

//	public boolean checkForFile(String str) {
//		if (attempts < MAXATTEMPTS) {
//			attempts++;
//			try {
//				fileObj = new File(str);
//				return fileObj.exists();
//			} catch (SecurityException se) {
//				System.out.println("Security Exception: " + se.getMessage());
//				return false;
//			}
//		}
//		return false;
//	}