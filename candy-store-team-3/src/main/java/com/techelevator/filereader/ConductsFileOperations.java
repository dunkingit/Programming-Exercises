//package com.techelevator.filereader;
//
//import com.techelevator.view.UserInput;
//
//import java.io.File;
//
//import static com.techelevator.filereader.FileClass.DEFAULT_FILE_NAME;
//
//public class ConductsFileOperations {
//    private static final int MAXATTEMPTS = 3;
//    private int attempts = 0;
//    private File fileObj;
//
//    public boolean checkForFile(String str) {
//
//        if (fileObj.exists()) {
//            return true;
//        } else {
//            System.out.println("File not found! Please try again.");
//            return false;
//        }
//    }
//    public File getFileObj() {
//        return this.fileObj;
//    }
//    public String promptForFile(UserInput ui) {
//        while (true) {
//
//            String filename = ui.input("Enter File name (or 'default' for default file): ");
//            if (filename.equalsIgnoreCase("default")) {
//                return DEFAULT_FILE_NAME;  // Assuming this constant is accessible.
//            }
//            if (checkForFile(filename)) {
//                return filename;
//            }
//            System.out.println("File not found. Try again.");
//        }
//        System.out.println("Maximum attempts reached. Using default file.");
//        return DEFAULT_FILE_NAME;
//    }
//}    public FileClass() {
////        ConductsFileOperations fileOperations = new ConductsFileOperations();
////        if (!fileOperations.checkForFile(DEFAULT_FILE_NAME)) {
////            this.fileObj = new File(DEFAULT_FILE_NAME);
////        } else {
////            this.fileObj = fileOperations.getFileObj();
////        }
////    }package com.techelevator.filereader;
////import java.io.File;
////
////abstract class FileClass {
////    protected String filePath;
////    protected String outputFileName;
////    protected File fileObj;
////    protected String errorFile = "Errorlog.txt";
////    public static final String DEFAULT_FILE_NAME = "inventory.csv";
////    public static final String DEFAULT_RANDOM_FILE_NAME = "Random.csv";
////    public static final String ERROR_FILE_NAME = "Errorlog.txt";
////    public static final String DEFAULT_LOG_FILE_NAME = "log.txt";
////}
