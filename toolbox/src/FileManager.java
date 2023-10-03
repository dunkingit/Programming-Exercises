import java.io.File;
import java.io.FileNotFoundException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
    private String fileName;
    private Scanner dataInput;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StringBuilder read(String filename){
        this.setFileName(filename);
        StringBuilder text = new StringBuilder();
    try(Scanner dataInput = new Scanner(new File(fileName))){
        while(dataInput.hasNextLine()){
            text.append(dataInput.nextLine() + "\n");
        }
    }catch (FileNotFoundException nofile){
        System.out.println(nofile.getMessage());
        System.out.println("Creating file..." + filename);
        this.write("");
        return this.read(filename);
    }
    return text;
    }

    public void write(String str){

        try (PrintWriter print = new PrintWriter(this.fileName)){
            print.println(str);

        }catch (FileNotFoundException fileex){
            System.err.println(fileex);
        }
    }

    public void write(){

        try (PrintWriter print = new PrintWriter(this.fileName)){
            print.println("Creating file");

        }catch (FileNotFoundException fileex){
            System.err.println(fileex);
        }
    }
}