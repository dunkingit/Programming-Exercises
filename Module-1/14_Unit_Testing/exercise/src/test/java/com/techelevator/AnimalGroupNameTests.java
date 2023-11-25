package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTests {
    private AnimalGroupName getName;

    private final String errorMessage1 = "Expected herd name for elephant is 'Herd'";
    private final String errorMessage2 = "Expected herd name for deer is 'Herd'";
    private final String errorMessage3 = "Animal name should be case insensitive";
    private final String errorMessage4 = "If the name of the animal is not found, should return 'unknown'";
    private final String errorMessage5 = "If the name of the animal is null or empty, should return 'unknown'";

    @Before
    public void setup() {
        getName = new AnimalGroupName();
        System.out.println("Setting up environment");
    }

    @Test
    public void AnimalGroupName_getHerd_return_Herd_for_elephant() {
        String input = "elephant";
        String expected = "Herd";
        String actual = getName.getHerd(input);
        Assert.assertEquals(errorMessage1, expected, actual);
    }

    @Test
    public void AnimalGroupName_getHerd_return_Herd_for_deer() {
        String input = "deer";
        String expected = "Herd";
        String actual = getName.getHerd(input);
        Assert.assertEquals(errorMessage2, expected, actual);
    }

    @Test
    public void AnimalGroupName_getHerd_return_Herd_for_ELEPHANT_case_insensitive() {
        String input = "ELEPHANT";
        String expected = "Herd";
        String actual = getName.getHerd(input);
        Assert.assertEquals(errorMessage3, expected, actual);
    }

    @Test
    public void AnimalGroupName_getHerd_return_unknown_for_Cat() {
        String input = "Cat";
        String expected = "unknown";
        String actual = getName.getHerd(input);
        Assert.assertEquals(errorMessage4, expected, actual);
    }

    @Test
    public void AnimalGroupName_getHerd_return_unknown_for_empty_string() {
        String input = "";
        String expected = "unknown";
        String actual = getName.getHerd(input);
        Assert.assertEquals(errorMessage5, expected, actual);
    }
}

