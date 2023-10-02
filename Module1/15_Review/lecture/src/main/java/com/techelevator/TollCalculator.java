package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TollCalculator {
    public static  void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(true));
        vehicles.add(new Car(false));
        vehicles.add(new Truck(4));
        vehicles.add(new Truck(6));
        vehicles.add(new Truck(8));
        vehicles.add(new Tank());

        Random random = new Random();
        // (10 to 240)
        int upperBound = 240;
        int lowerBound = 10;
        Random rand = new Random();
        double sumTotal = 0;
        int sumDistance = 0;


        StringBuilder text = new StringBuilder("Vehicle            Distance Traveled      Toll $\n" +
                "------------------------------------------------\n");
        int len = 20;
        for(Vehicle each: vehicles){
            String name = each.toString();
            int spaces = len - name.length();
            double toll = each.calculateToll(rand.nextInt(240));
            sumTotal += toll;
            sumDistance += each.getDistance();
            int spaces2 = len -  String.valueOf(each.getDistance()).length();;
            text.append(name + " ".repeat(spaces) + each.getDistance() + " ".repeat(spaces2) + "$"+ toll + "\n");
        }

        String totalDistance = "Total Miles Traveled: " + sumDistance;
        String totalSum = "Total Tollbooth Revenue: " + sumTotal;

        text.append(totalDistance + "\n");
        text.append(totalSum + "\n");

        System.out.println(text);


    }



}
