package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTests {
    AnimalGroupName getName;

    @Before
    public void setup(){
        getName = new AnimalGroupName();
        System.out.println("Setting up enviroment");
    };

    @Test
    public void Get_AnimalGroupName_returns_name_from_map_in_a_String(){

        //Arrange
        String questiontest1 = "elephant";
        String answertest1 = "Herd";
        String questiontest2 = "deer";
        String answertest2 = answertest1;


        //Act
        String test1 = getName.getHerd(questiontest1);
        String test2 = getName.getHerd(questiontest2);

        //Edge case
        //The animal name should be case insensitive
        //If the name of the animal is not found, null, or empty, return "unknown".
        String upperCase = questiontest1.toUpperCase();
        String unknownName = "Cat";
        String emptyString = "";

        String testUpperCase = getName.getHerd(upperCase);
        String testUnknownName = getName.getHerd(unknownName);
        String testEmptyString = getName.getHerd(emptyString);

        // Assert
        Assert.assertEquals("Expected herd name for elephant is 'Herd'", answertest1, test1);
        Assert.assertEquals("Expected herd name for deer is 'Herd'", answertest2, test2);
        Assert.assertEquals("Animal name should be case insensitive", answertest1, testUpperCase);
        Assert.assertEquals("If the name of the animal is not found, should return 'unknown'", "unknown", testUnknownName);
        Assert.assertEquals("If the name of the animal is null or empty, should return 'unknown'", "unknown", testEmptyString);
    }


    };
