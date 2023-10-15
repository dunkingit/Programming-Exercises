public class test {
    String message1 = "How much would you like to deposit today?";
    String message2 = "Our system can securely hold up to $1000.";
    String message3 = "You may insert up to $100 at a time. ";
    String message4 = "Thank you for choosing our vending machine!";

    public String fullbox(String str, int boxsize){
    return this.topbox(boxsize) + "\n" +
           this.centerbox(str, boxsize) + "\n" +
           this.bottombox(boxsize);
    }

    public String topbox (int num){
        return "╔" + "═".repeat(num - 1) + "╗";
    };

    public String centerbox(String str, int num){
        int width = num;
        String s = str;
        int padSize = width - s.length();
        int padStart = s.length() + padSize / 2;
//        String bar = "║" + " ".repeat(padSize / 2) + str +  " ".repeat(padSize / 2) + "║";
        s = String.format("║%" + padStart + "s", s);
        s = String.format("%-" + width  + "s"+"║", s);
        return s;
    }

    public String bottombox (int num){
        return "╚" + "═".repeat(num - 1) + "╝";
    };
}
