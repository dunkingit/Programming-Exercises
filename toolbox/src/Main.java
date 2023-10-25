import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main.run();
    }

    public static void run(){
        test(null);
    }

    public static void test(Double num){
        System.out.println("This number is: " + num.);
    }



//        List<String> alist = new ArrayList<>();
//
//        Parent pa = new Parent();
//        pa.theList(alist);
//        System.out.println(pa.outList().toString());
//        pa.addto("test");
//        System.out.println(pa.outList().toString());
//
//        ChildA a = new ChildA();
//        ChildB b = new ChildB();
//
//        a.incrementByTwo();
//        a.incrementByTwo();
//        System.out.println(a.getValue()); // prints 12
//
//        System.out.println(b.getValue()); // prints 12
//        a.outList();
//        b.outList();
//        a.addto("ChildA");
//        b.addto("ChildB");
//        System.out.println(a.outList().toString());
//        System.out.println(b.outList().toString());
//        a.addto("ChildA");
//        System.out.println(a.outList().toString());
//        System.out.println(b.outList().toString());



//        JTextArea messageText;
//        test atest = new test();
//        atest.fullbox("How much would you like to deposit today? ", 50);
//        JFrame window = new JFrame();
//        int width = 1000;
//        int length = 1000;
//        int centerWidth = width / 2;
//        int centerLength = length / 2;
//
//        window.setSize(width, length);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.getContentPane().setBackground(Color.black);
//        window.setLayout(null);
//        String aa = atest.fullbox("aaa ", 30);
//        messageText = new JTextArea(aa);
//        messageText.setBounds(centerWidth - 200, centerLength - 300, 1200, 1000);
//        messageText.setBackground(Color.black);
//        messageText.setForeground(Color.white);
//        messageText.setEditable(false);
//        messageText.setLineWrap(false);
//        messageText.setWrapStyleWord(true);
////        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
////        messageText.setFont(new Font("Monospaced", Font.PLAIN, 20));
//        window.add(messageText);
//
//
//
//        window.setVisible(true);

        // Load the resource bundle
//        Locale currentLocale = Locale.getDefault();
//        ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);
//
//        // Retrieve messages
//        String welcome = messages.getString("message1");
//
//        System.out.println(welcome);        Random random = new Random();
//        int[] al = new int[10];
//        int index = 0;
//        while (true) {
//            int num = random.nextInt(11);
//            boolean inList = false;
//            for (int each: al) {
//                if (each == num){
//                    inList = true;
//                }
//            }
//            if(!inList){
//                al[index] = num;
//                index++;
//            }
//            if(index == 9){
//                break;
//            }
//        }
//
//        System.out.println(Arrays.toString(al));

    }