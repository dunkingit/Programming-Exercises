package com.techelevator;

public class Mod1Assessment {

    public static void main(String[] args) {
        //make an instance of PC
        PC dell = new PC("NITEL", "8GB", "FORCEG");
        dell.getCpu();
        PC hp = new PC("DAM", "16GB", "EONRAD");
        System.out.println(dell);
        System.out.println(hp);
    }
}
