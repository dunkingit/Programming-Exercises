package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// (function)_should_return_4_when_(passed)_and_(passed)_are_passed
public class StringBitsTests {

    @Test
    public void  getBits_should_return_even_string_of_characters_when_String_str_are_passed(){
        // Arrange
        StringBits bits = new StringBits();
        // Act
        String case1 = bits.getBits(" Hello");
        String case2 = bits.getBits("Hello");
        String case3 = bits.getBits("");
        // Assert
        Assert.assertEquals(case1, " el");
        Assert.assertEquals(case2, "Hlo");
        Assert.assertEquals(case3, "");
    };
}
