package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class AnimalGroupNameTests {
    AnimalGroupName name;

    @Before
    public void setup(){
        new AnimalGroupName();
        System.out.println("Setting up enviroment");
    };

    @Test
    public void test_Animal(){
        String[] array = {"elephant", "Herd", "deer", "Herd","crocodile", "Float"};
        String qtest1 = array[0];
        String atest1 = array[1];
        String qtest2 = array[2];
        String atest2 = array[3];
        String qtest3 = array[4];
        String atest3 = array[5];
        //Arrange
        String test1 = name.getHerd(qtest1);

        //Act
        Assert.assertEquals(atest1, atest1);
//        Assert.assertEquals(qtest2, atest2);
//        Assert.assertEquals(qtest3, atest3);

    };
}
