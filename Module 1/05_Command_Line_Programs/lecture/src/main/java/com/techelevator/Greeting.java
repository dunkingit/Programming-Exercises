package com.techelevator;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Greeting {

    public static void main(String[] args){
        System.out.println("Welveom to the program! ");
        System.out.println("What is your name? ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

    }
}
