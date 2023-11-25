package com.techelevator;

import com.techelevator.DateFashion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion table;
    @Before
    public void initialize() {
        System.out.println("Beginning Setup");
        table = new DateFashion();
    }

    @Test
    public void DateFashion_getATable_returns_int_for_high_style_and_average_style() {
        int highStyle = 8;
        int result = table.getATable(highStyle, 5);
        Assert.assertEquals(2, result);
    }

    @Test
    public void DateFashion_getATable_returns_int_for_low_style_and_average_style() {
        int lowStyle = 2;
        int result = table.getATable(lowStyle, 5);
        Assert.assertEquals(0, result);
    }

    @Test
    public void DateFashion_getATable_returns_int_for_average_style_and_average_style() {
        int result = table.getATable(5, 5);
        Assert.assertEquals(1, result);
    }

    @Test
    public void DateFashion_getATable_returns_int_for_high_style_and_low_style() {
        int highStyle = 8;
        int lowStyle = 2;
        int result = table.getATable(highStyle, lowStyle);
        Assert.assertEquals(0, result);
    }
}


