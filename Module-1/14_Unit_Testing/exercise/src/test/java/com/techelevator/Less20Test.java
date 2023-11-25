package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Less20Test {
    private Less20 less20_instance;
    private final String ERROR_MESSAGE_1 = "Expected result didn't match the actual result";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected result";

    @Before
    public void setup() {
        less20_instance = new Less20();
    }

    @Test
    public void Less20_isLessThanMultipleOf20_return_boolean_should_return_false_for_negitive() {
        boolean actualResult = less20_instance.isLessThanMultipleOf20(-18);
        assertEquals(ERROR_MESSAGE_1, false, actualResult);
    }

    @Test
    public void Less20_isLessThanMultipleOf20_return_boolean_should_return_true_for_19() {
        boolean actualResult = less20_instance.isLessThanMultipleOf20(19);
        assertEquals(ERROR_MESSAGE_1, true, actualResult);
    }

    @Test
    public void Less20_isLessThanMultipleOf20_return_boolean_should_return_false_for_20() {
        boolean actualResult = less20_instance.isLessThanMultipleOf20(20);
        assertEquals(ERROR_MESSAGE_2, false, actualResult);
    }

    @Test
    public void Less20_isLessThanMultipleOf20_return_boolean_should_return_false_for_0() {
        boolean actualResult = less20_instance.isLessThanMultipleOf20(0);
        assertEquals(ERROR_MESSAGE_2, false, actualResult);
    }

    @Test
    public void Less20_isLessThanMultipleOf20_return_boolean_should_return_false_for_negitive_number() {
        boolean actualResult = less20_instance.isLessThanMultipleOf20(-20);
        assertEquals(ERROR_MESSAGE_2, false, actualResult);
    }
}
