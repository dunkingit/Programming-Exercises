package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MovieRentalTests {


    public MovieRentalTests() {
        System.out.println("Beginning test");
    };

    @Test
    public void MovieRental_returns_VHS_Price(){
        MovieRental rental = new MovieRental("Cars", "VHS", true);
        Assert.assertEquals("Cars - VHS - $0.99", rental.toString());

    }

    public void MovieRental_returns_none_wrong_format(){
        MovieRental rental = new MovieRental("Cars", "", true);
        Assert.assertEquals("Cars - VHS - $0.99", rental.toString());

    }

    public void MovieRental_returns_none_no_title(){
        MovieRental rental = new MovieRental("Cars", "", true);
        Assert.assertEquals("Cars - VHS - $0.99", rental.toString());

    }
}
