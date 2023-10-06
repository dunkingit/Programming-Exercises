import javax.lang.model.element.NestingKind;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {


        double change = 84.93;
        double[] moneyChange = {20.00, 10.00, 5.0, 1.00, 0.25, 0.10, 0.05, 0.01};
        String[] wordChange = {"Twenties", "Ten", "Five", "Dollar", "Quarter", "Dime", "Nickel", "Penny"};
        String textChange = "";
        int counter = 0;
        while(change >= 0 && counter <= 7){
            int div = (int)(change / moneyChange[counter]);
            if (div > 0){
                change = change - (div * moneyChange[counter]);
                textChange += "(" + (int)div + ") " + wordChange[counter] + " ";
            }
            counter++;
        }

        System.out.println(textChange);
//        change=change%100;
//        int quarters = Math.round(change/25);
//        change=change%25;
//        int dimes = Math.round(change/10);
//        change=change%10;
//        int nickels = Math.round(change/5);
//        change=change%5;
//        int pennies = Math.round(change/1);

//        System.out.println("Quarters: " + quarters);
//        System.out.println("Dimes: " + dimes);
//        System.out.println("Nickels: " + nickels);
//        System.out.println("Pennies: " + pennies);

//        FileManager fm = new FileManager();
//        StringBuilder filetext = fm.read("test1.txt");
//        System.out.println(filetext);
//        TestGui test = new TestGui(400, 400);

//        Map<String, String[]> dict = new HashMap<>();
//
//        dict.put("a2", new String[]{"a2", "b2"});
//        dict.put("a1", new String[]{"a1", "b1"});
//        dict.put("a4", new String[]{"a4", "b4"});
//        dict.put("A4", new String[]{"A4", "B4"});
//        dict.put("c3", new String[]{"c3", "b3"});
//        dict.put("d3", new String[]{"d3", "b3"});
//        List<String> alist = new ArrayList<>(dict.keySet());
//        Collections.sort(alist);;
//        for(String each: alist){
//            System.out.println(Arrays.toString(dict.get(each)));
//        }
//        System.out.println(alist);

    }
}