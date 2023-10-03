import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
    private String filename;
    private File dataFile;
    private Scanner dataInput;
    PrintWriter dataOutput;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public void read() throws FileNotFoundException {
        this.dataFile = new File(this.filename);
        this.dataInput = new Scanner(dataFile);
        System.out.println("Variables Created Successfully. ");
    };

    public StringBuilder getTextFromFile(){
        StringBuilder text = new StringBuilder("Reading:" + filename);
        while (this.dataInput.hasNextLine()) {
            String lineOfInput = this.dataInput.nextLine();
            text.append(lineOfInput);
        }
        System.out.println("File Reading Successful. ");
        return text;
    }

    public void setFilename(String str){
        this.filename = str;
    }

//    text.append("Successful.");
//        text.append("Was not successful.");
    public void write(String stringText) throws FileNotFoundException {
        dataOutput = new PrintWriter(dataFile);
        dataOutput.println(stringText);
        System.out.println(dataOutput.toString());
    };
};
