package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MaxEnd3Test {
    private MaxEnd3 maxEnd3_instance;
    private final String ERROR_MESSAGE_1 = "Expected array didn't match the actual array";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected array";
    @Before
    public void setup() {
        maxEnd3_instance = new MaxEnd3();
    }

    @Test
    public void MaxEnd3_makeArray_return_array_with_3s_should_return_array_with_3s_for_1_2_3() {
        int[] nums = {1, 2, 3};
        int[] expectedResult = {3, 3, 3};
        int[] actualResult = maxEnd3_instance.makeArray(nums);
        assertArrayEquals(ERROR_MESSAGE_1, expectedResult, actualResult);
    }

    @Test
    public void MaxEnd3_makeArray_return_array_with_11s_should_return_array_with_11s_for_11_5_9() {
        int[] nums = {11, 5, 9};
        int[] expectedResult = {11, 11, 11};
        int[] actualResult = maxEnd3_instance.makeArray(nums);
        assertArrayEquals(ERROR_MESSAGE_1, expectedResult, actualResult);
    }

    @Test
    public void MaxEnd3_makeArray_return_array_with_3s_should_return_array_with_3s_for_2_11_3() {
        int[] nums = {2, 11, 3};
        int[] expectedResult = {3, 3, 3};
        int[] actualResult = maxEnd3_instance.makeArray(nums);
        assertArrayEquals(ERROR_MESSAGE_2, expectedResult, actualResult);
    }

    @Test
    public void MaxEnd3_makeArray_return_array_with_3s_should_return_array_of_zeros() {
        int[] nums = {0, 11 ,0};
        int[] expectedResult = {0, 0, 0};
        int[] actualResult = maxEnd3_instance.makeArray(nums);
        assertArrayEquals(ERROR_MESSAGE_2, expectedResult, actualResult);
    }

    @Test
    public void MaxEnd3_makeArray_return_array_with_3s_should_return_array_of_negitives() {
        int[] nums = {-14, -7 ,-4};
        int[] expectedResult = {-4, -4, -4};
        int[] actualResult = maxEnd3_instance.makeArray(nums);
        assertArrayEquals(ERROR_MESSAGE_2, expectedResult, actualResult);
    }


}
