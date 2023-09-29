package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LectureTest {

    private Lecture lecture;

    @Before
    public void setup(){
        lecture = new Lecture();
    }

    @Test
    public void or35_return_true_when_passed_multiple_of_three(){
        //arrange
//        int three = 4;
        //act
        boolean result = lecture.or35(3);
        //assert
        Assert.assertTrue("When I passed in 3 or35() should return true", result);
    }

    @Test
    public void or35_return_true_when_passed_multiple_of_five(){
        //arrange - good to go
        //call the freaking method - act
       boolean result =  lecture.or35(5);
       Assert.assertTrue("When I passed in 5 or35() should return true", result);
    }

    @Test
    public void or35_return_false_when_passed_a_non_multiple_of_three_or_five(){
        boolean result = lecture.or35(4);
        Assert.assertFalse(result);
    }

    @Test
    public void firstTwo_returns_string_when_str_length_equal_2(){
        String result = lecture.firstTwo("ab");
        Assert.assertEquals("ab", result);
    }

    @Test
    public void firstTwo_returns_string_when_str_length_less_than_2(){
        String result = lecture.firstTwo("a");
        Assert.assertEquals("a", result);
    }

    @Test
    public void firstTwo_returns_string_with_first_2_char_when_str_length_greater_than_2(){
        String result = lecture.firstTwo("abcde");
        Assert.assertEquals("ab", result);
    }

    @Test
    public void firstTwo_returns_empty_string_when_passed_empty_string(){
        String result = lecture.firstTwo("");
        Assert.assertEquals("", result);
    }

    @Test
    public void firstTwo_null_issues(){
        Assert.assertNotNull(lecture.firstTwo(null));
    }

}
