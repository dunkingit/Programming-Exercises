package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {
    DateFashion table;

    @Before
    public void beginSetup(){
        System.out.println("Beginning Setup");
        table = new DateFashion();
    };

    @Test
    public void testMethod(){

//  If either of you is very stylish, 8 or more, then the result is 2 (yes)
//  If either of you has style of 2 or less
//  Otherwise the result is 1 (maybe)
        //Step 1: Arrange

        int edgeHigh = 8;
        int edgeLow = 2;

        //Step 2: Act
        int test1 = table.getATable(edgeHigh, 5);
        int test2 = table.getATable(edgeLow, 5);
        int test3 = table.getATable(5, 5);
        //With the exception that if either of you has style of
        //    2 or less, then the result is 0 (no)
        int test4 = table.getATable(edgeHigh, edgeLow);

        //Step 3: Assert

        Assert.assertEquals(2, test1);
        Assert.assertEquals(0, test2);
        Assert.assertEquals(1, test3);
        Assert.assertEquals(0, test4);


    };
}
