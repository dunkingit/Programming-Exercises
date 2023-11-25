package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SameFirstLastTest {
    private SameFirstLast sameFirstLast_instance;
    private final String ERROR_MESSAGE_1 = "Expected result didn't match the actual result";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected result";
    @Before
    public void setup() {
        sameFirstLast_instance = new SameFirstLast();
    }

    @Test
    public void SameFirstLast_isItTheSame_return_boolean_should_return_false_for_1_2_3() {
        int[] nums = {1, 2, 3};
        boolean actualResult = sameFirstLast_instance.isItTheSame(nums);
        assertEquals(ERROR_MESSAGE_1, false, actualResult);
    }

    @Test
    public void SameFirstLast_isItTheSame_return_boolean_should_return_true_for_1_2_3_1() {
        int[] nums = {1, 2, 3, 1};
        boolean actualResult = sameFirstLast_instance.isItTheSame(nums);
        assertEquals(ERROR_MESSAGE_1, true, actualResult);
    }

    @Test
    public void SameFirstLast_isItTheSame_return_boolean_should_return_true_for_1_2_1() {
        int[] nums = {1, 2, 1};
        boolean actualResult = sameFirstLast_instance.isItTheSame(nums);
        assertEquals(ERROR_MESSAGE_2, true, actualResult);
    }
    @Test
    public void SameFirstLast_isItTheSame_return_boolean_should_return_false_for_null() {
        int[] nums = null;
        boolean actualResult = sameFirstLast_instance.isItTheSame(nums);
        assertEquals("Unexpected result for null array", false, actualResult);
    }
    @Test
    public void SameFirstLast_isItTheSame_return_boolean_should_return_false_for_empty_array() {
        int[] nums = {};
        boolean actualResult = sameFirstLast_instance.isItTheSame(nums);
        assertEquals("Unexpected result for empty array", false, actualResult);
    }

}

