import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            String filename = "./test1";
            FileManager fm = new FileManager(filename);
            try {
                fm.read();
            }catch (Exception ee){
                System.out.println(ee);
            }
            try {
                fm.write("Writing to file. Testing this feature. ");
            }catch (Exception ee){
                System.out.println(ee);
            }
            System.out.println("Variables Created Successfully. ");
        }catch (Exception fe){
            System.err.println("Error has occured");
        }
    }
}
