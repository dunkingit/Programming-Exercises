package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    private WordCount wordCount_instance;
    private final String ERROR_MESSAGE_1 = "Expected result didn't match the actual result";
    private final String ERROR_MESSAGE_2 = "Edge case didn't produce the expected result";

    @Before
    public void setup() {
        wordCount_instance = new WordCount();
    }

    @Test
    public void WordCount_getCount_return_map_should_return_map_for_ba_ba_black_sheep() {
        String[] words = {"ba", "ba", "ba", "ba","ba", "ba","black", "sheep"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 6);
        expected.put("black", 1);
        expected.put("sheep", 1);

        Map<String, Integer> actualResult = wordCount_instance.getCount(words);
        assertEquals(ERROR_MESSAGE_1, expected, actualResult);
    }

    @Test
    public void WordCount_getCount_return_map_should_return_map_for_a_b_a_c_b() {
        String[] words = {"a", "b", "a", "c", "b"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);

        Map<String, Integer> actualResult = wordCount_instance.getCount(words);
        assertEquals(ERROR_MESSAGE_1, expected, actualResult);
    }

    @Test
    public void WordCount_getCount_return_empty_map_should_return_empty_map_for_empty_array() {
        String[] words = {};
        Map<String, Integer> expected = new HashMap<>();

        Map<String, Integer> actualResult = wordCount_instance.getCount(words);
        assertEquals(ERROR_MESSAGE_2, expected, actualResult);
    }

    @Test
    public void WordCount_getCount_return_map_should_return_map_for_c_b_a() {
        String[] words = {"c", "c","c","b", "b","b","b","b","a"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("c", 3);
        expected.put("b", 5);
        expected.put("a", 1);
        Map<String, Integer> actualResult = wordCount_instance.getCount(words);
        assertEquals(ERROR_MESSAGE_2, expected, actualResult);
    }

}

