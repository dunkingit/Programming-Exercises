package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lucky13Test {
    private Lucky13 lucky13_instance;
    private final String ERROR_MESSAGE_1 = "Expected result didn't match the actual result";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected result";

    @Before
    public void setup() {
        lucky13_instance = new Lucky13();
    }

    @Test
    public void Lucky13_getLucky_return_boolean_should_return_boolean_for_array_without_1_or_3_true() {
        int[] nums = {0, 2, 4};
        boolean actualResult = lucky13_instance.getLucky(nums);
        assertEquals(ERROR_MESSAGE_1, true, actualResult);
    }

    @Test
    public void Lucky13_getLucky_return_boolean_should_return_boolean_for_array_with_1_and_3_false() {
        int[] nums = {1, 2, 3};
        boolean actualResult = lucky13_instance.getLucky(nums);
        assertEquals(ERROR_MESSAGE_1, false, actualResult);
    }

    @Test
    public void Lucky13_getLucky_return_boolean_should_return_boolean_for_array_with_just_1_true() {
        int[] nums = {1, 2, 4};
        boolean actualResult = lucky13_instance.getLucky(nums);
        assertEquals(ERROR_MESSAGE_2, true, actualResult);
    }

    @Test

    //* Given an array of ints, return true if the array
    public void Lucky13_getLucky_return_boolean_should_return_boolean_test_null() {
        boolean actualResult = lucky13_instance.getLucky(null);
        assertEquals(ERROR_MESSAGE_2, false, actualResult);
    }

}
