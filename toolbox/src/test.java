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

    public void takeMoneyOption(int balance) {
        String overage = "Sorry at this time we can not accept bills over a $100\n" +
                "Please try again";
        String over1000 = "We're sorry but depositing that much would exceed the maximum allowance of $1000";
        String invalidAmmount = "You have entered a invalid amount.\n" +
                "Please try again. ";
        int enterNumbered = balance;

        System.out.println(
                enterNumbered < 0? invalidAmmount:
                                enterNumbered + balance > 1000? over1000:
                                        enterNumbered > 100? overage:"Thank you");

    }
}
