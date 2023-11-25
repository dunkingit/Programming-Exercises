package com.techelevator;

public class Truck implements Vehicle{
    int numberOfAxles;
    private int distance;

    public Truck(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }
    public double calculateToll(int distance){
        this.distance = distance;
        return numberOfAxles == 4? distance * 0.040:
                numberOfAxles == 6? distance * 0.045:
                        distance *0.048;
    }
    public String toString() {
        return "Truck ("+ numberOfAxles + "axels)  ";
    }

    public int getDistance() {
        return distance;
    }
}
