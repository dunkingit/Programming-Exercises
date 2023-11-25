import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String Steven = "Steven";
        String Anisa = "Anisa";
        Random random = new Random();
        int num = random.nextInt(10000);
        String driver;
        if(num % 2 == 0){
            driver = Steven;
        }else {
            driver = Anisa;
        }
        System.out.println("The driver is: " + driver);
    }
}