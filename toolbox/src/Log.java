import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    static String logFileName = "testing.txt";

    public static void output(String file, String action){
        logFileName = file.isEmpty()? "testtest.txt":file;
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        System.out.println(file + ": " + logFileName);
        writeLog(String.format("%s Event: %s", formattedDate, action));

    }

    public static void writeLog(String str) {
        System.out.println(str + ": " + logFileName);
        try(PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(logFileName, true)))){
            print.println(str);
        }catch(IOException io){
            System.out.println("Error: " + io);
        }
    }
}