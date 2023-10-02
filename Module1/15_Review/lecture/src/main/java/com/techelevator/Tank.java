package com.techelevator;

public class Tank implements Vehicle{
    int toll = 0;
    private int distance;

    @Override
    public String toString() {
        return "Tank";
    }


    @Override
    public double calculateToll(int distance){
        this.distance = distance;
        return (double) toll;
    }

    public int getDistance() {
        return distance;
    }
}
