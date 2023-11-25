package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
    private FrontTimes frontLetters;

    private final String errorMessage1 = "Expected result didn't match for 'Chocolate' and 2 repetitions";
    private final String errorMessage2 = "Expected result didn't match for 'Abc' and 3 repetitions";
    private final String errorMessage3 = "Expected result didn't match for empty string and 3 repetitions";
    private final String errorMessage4 = "Expected result didn't match for 'Chocolate' and -2 repetitions";

    @Before
    public void beginSetup() {
        System.out.println("Beginning Setup");
        frontLetters = new FrontTimes();
    }

    @Test
    public void FrontTimes_generateString_return_String_for_Chocolate_and_2() {
        String word = "Chocolate";
        String expected = "ChoCho";
        String actualResult = frontLetters.generateString(word, 2);
        Assert.assertEquals(errorMessage1, expected, actualResult);
    }

    @Test
    public void FrontTimes_generateString_return_String_for_Abc_and_3() {
        String word = "Abc";
        String expected = "AbcAbcAbc";
        String actualResult = frontLetters.generateString(word, 3);
        Assert.assertEquals(errorMessage2, expected, actualResult);
    }

    @Test
    public void FrontTimes_generateString_return_empty_string_for_empty_string_and_3() {
        String word = "";
        String expected = "";
        String actualResult = frontLetters.generateString(word, 3);
        Assert.assertEquals(errorMessage3, expected, actualResult);
    }

    @Test
    public void FrontTimes_generateString_return_empty_string_for_Chocolate_and_negative_2() {
        String word = "Chocolate";
        int negNumber = -2;
        String expected = "";
        String actualResult = frontLetters.generateString(word, negNumber);
        Assert.assertEquals(errorMessage4, expected, actualResult);
    }
}

