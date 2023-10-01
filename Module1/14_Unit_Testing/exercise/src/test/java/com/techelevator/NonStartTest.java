package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NonStartTest {
    private NonStart nonStart_instance;
    private final String ERROR_MESSAGE_1 = "Expected result didn't match the actual result";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected result";
    @Before
    public void setup() {
        nonStart_instance = new NonStart();
    }

    @Test
    public void NonStart_getPartialString_return_String_should_return_ellohere_for_Hello_There() {
        String actualResult = nonStart_instance.getPartialString("Hello", "There");
        assertEquals(ERROR_MESSAGE_1, "ellohere", actualResult);
    }

    @Test
    public void NonStart_getPartialString_return_String_should_return_Hello_for_java_code() {
        String actualResult = nonStart_instance.getPartialString(" ", " Hello");
        assertEquals(ERROR_MESSAGE_1, "Hello", actualResult);
    }

    @Test
    public void NonStart_getPartialString_return_String_should_return_hotlava_for_shotl_java() {
        String actualResult = nonStart_instance.getPartialString("shotl", "java");
        assertEquals(ERROR_MESSAGE_2, "hotlava", actualResult);
    }
}

