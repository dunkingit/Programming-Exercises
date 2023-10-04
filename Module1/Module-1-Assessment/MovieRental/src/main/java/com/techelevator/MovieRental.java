package com.techelevator;

import java.util.InvalidPropertiesFormatException;

public class MovieRental {
    String title;
    String format;
    boolean isPremiumMovie;
    double rentalPrice;

    @Override
    public String toString() {
        //"MOVIE - {title} - {format} {rental price}"
        return "Movie - " + this.title + " - " + this.format + " - " + "$" +  this.rentalPrice + "";
    }

    public MovieRental(String title, String format, boolean isPremiumMovie) {
        this.title = title;
        if(format.equals("VHS") || format.equals("DVD") || format.equals("Blu-ray") && !format.isEmpty()) {
            this.format = format;
        }else {
            this.format = "N/A No proper format has been entered. ";
        }
        this.isPremiumMovie = isPremiumMovie;
        this.rentalPrice = format.equals("VHS") ? 0.99 : format.equals("DVD") ? 1.99 : 3.99;
        if(isPremiumMovie){
            this.rentalPrice += 1;
        }

    }
    //indicates the rental price
    // (VHS $0.99, DVD $1.99, BluRay $2.99).
    // Premium movies add an additional $1.00 to the rental price.

    public double calculateLateFee(int daysLate){
        //Create a method that determines the movie's late
        // fee using an input parameter: int daysLate:
        //Return $0.00 if daysLate is equal to 0.
        //Return $1.99 if daysLate is equal to 1.
        //Return $3.99 if daysLate is equal to 2.
        //Return $19.99 if daysLate is equal to 3 or more.
        if(daysLate >= 3){
            return this.rentalPrice = 19.99;
        }
        if(daysLate == 2){
            return this.rentalPrice = 3.99;
        }
        if(daysLate == 1){
            return this.rentalPrice = 1.99;
        }
        return this.rentalPrice = 0;
    }
}
