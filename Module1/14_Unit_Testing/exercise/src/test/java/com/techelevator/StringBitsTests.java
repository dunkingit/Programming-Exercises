package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringBitsTests {
    private StringBits bits;

    @Before
    public void setup() {
        bits = new StringBits();
    }

    @Test
    public void StringBits_getBits_return_el_for_space_Hello() {
        String input = " Hello";
        String expected = " el";
        String actual = bits.getBits(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StringBits_getBits_return_Hlo_for_Hello() {
        String input = "Hello";
        String expected = "Hlo";
        String actual = bits.getBits(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StringBits_getBits_return_empty_for_empty_string() {
        String input = "";
        String expected = "";
        String actual = bits.getBits(input);
        Assert.assertEquals(expected, actual);
    }
}

