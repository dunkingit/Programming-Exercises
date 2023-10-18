public class Unused {
}

//    String uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    String lowercase_letters = "abcdefghijklmnopqrstuvwxyz";
//       Random rand = new Random();
//        for (int i = 0; i < 1000; i++) {
//            char letter = lowercase_letters.charAt(rand.nextInt(0, 26));
//            if (letter == 'z'){
//                System.out.println(letter);
//                System.out.println("Letter Number: " + i + " is 'z'. ");
//            }
//
//        }

//        String otherLower = "aaabccdeffffffghijklmnopqrstuvwxyz";
//        Set<String> test = new HashSet<>();
//        String[] newtest = new String[]{otherLower};
//        Collections.frequency(Collections.singleton(otherLower), 'e');
//        System.out.println(Collections.frequency(Arrays.asList(otherLower.split("")), "f"));


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


//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            String[] array = {"select", "as", "where", "group by", "order by", "from"};
//            String message = scanner.nextLine().toLowerCase();
//            String newMessage = "";
//            StringBuilder sb = new StringBuilder(message);
//            for(String each: array ){
//                int ind = message.indexOf(each);
//                System.out.println(ind);
//                if(ind == 0){
//                    sb.replace(ind, ind + each.length(), " \n" + each.toUpperCase());
//                    continue;
//                }
//                if(ind != -1){
//                    System.out.println(ind);
//                    System.out.println(each.length());
//                    System.out.println("Start: " + ind);
//                    System.out.println("Both: " + ind + each.length());
//                sb.replace(ind +2, ind +  2+  each.length(), " \n" + each.toUpperCase());
//            }
//            }
//            System.out.println(sb);
