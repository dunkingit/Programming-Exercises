package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
        FrontTimes frontLetters;
    @Before
    public void beginSetup() {
        System.out.println("Beginning Setup");
        frontLetters = new FrontTimes();
    }

    @Test
    public void test_generateString_checks_front_characters_repetition() {

        //String Length Less than 3
        //Non-Positive
        //Empty String

        // Step 1: Arrange
        String word1 = "Chocolate";
        String word2 = "Abc";
        String emptyString = "";
        int negNumber = -2;

        String expected1 = "ChoCho";
        String expected2 = "AbcAbcAbc";
        String expected3 = emptyString;
        String expected4 = emptyString;

        // Step 2: Act
        String result1 = frontLetters.generateString(word1, 2);
        String result2 = frontLetters.generateString(word2, 3);
        String result3 = frontLetters.generateString(emptyString, 3);
        String result4 = frontLetters.generateString(word1, negNumber);

        // Step 3: Assert
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);
    }

}
