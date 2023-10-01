

import javax.lang.model.element.NestingKind;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {

       String uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String lowercase_letters = "abcdefghijklmnopqrstuvwxyz";
//       Random rand = new Random();
//        for (int i = 0; i < 1000; i++) {
//            char letter = lowercase_letters.charAt(rand.nextInt(0, 26));
//            if (letter == 'z'){
//                System.out.println(letter);
//                System.out.println("Letter Number: " + i + " is 'z'. ");
//            }
//
//        }

        String otherLower = "aaabccdeffffffghijklmnopqrstuvwxyz";
        Set<String> test = new HashSet<>();
        String[] newtest = new String[]{otherLower};
//        Collections.frequency(Collections.singleton(otherLower), 'e');
        System.out.println(Collections.frequency(Arrays.asList(otherLower.split("")), "f"));


//        String greetings = String.format(
//                "Hello %2$s, welcome to %1$s !",
//                otherLower,
//                14);
//
//        System.out.println(greetings);
//
//        int to = 32;
//        String check = "Without left justified flag: %";
//        String check2 = "With left justified flag: %";
//        int max = check.length() + 5;
//        int c1 = (to - check.length());
//        int c2 = (to - check2.length());
//
//        String s = String.format(check + c1 + "d", 25);
//        System.out.println(s);
//        s = String.format(check2 + c2 +"d", 25);
//        System.out.println(s);

        System.out.println(Main.class.getName());
    }

}