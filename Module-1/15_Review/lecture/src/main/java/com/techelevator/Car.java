package com.techelevator;

import java.util.Random;

public class Car implements Vehicle{
    boolean hasTrailer;
    int distance;

    public Car(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }
    @Override
    public String toString() {
        return hasTrailer? "Car (With Trailer)":"Car";
    }


    @Override
    public double calculateToll(int distance) {
        this.distance = distance;
        return hasTrailer? distance*0.020 +1.00: distance*0.020;
    }

    public int getDistance() {
        return distance;
    }

}
