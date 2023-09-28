package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoreLectureTests {
    Lecture testitem = new Lecture();
    @Test
    public void actualTest(){
        //Arrange
        String answer1 = "He";
        String answer2 = "Ca";
        String answer3 = "el";

        //Act
        String test1 = testitem.firstTwo("Hello");
        String test2 = testitem.firstTwo("Car");;
        String test3 = testitem.firstTwo("elephant");

        Assert.assertEquals(answer1, test1);
        Assert.assertEquals(answer1.length(), test1.length());
        Assert.assertEquals(answer2, test2);
        Assert.assertEquals(answer2.length(), test2.length());
        Assert.assertEquals(answer3, test3);
        Assert.assertEquals(answer3.length(), test3.length());


    }

}
