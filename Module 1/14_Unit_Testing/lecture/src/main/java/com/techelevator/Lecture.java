package com.techelevator;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lecture {


    /*
    8. Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
    (Hint: Think "mod".)
    or35(3) → true
    or35(10) → true
    or35(8) → false
    */
    public boolean or35(int n) {
        return (n % 3 == 0) || (n % 5 == 0);
    }


    /*
     Given a number turn double the value, unless the number is odd then return the original value.
     */
    public int doubleNumber(int number) {
        return number % 2 == 1 ? number : number * 2;
    }

    /*
    Given a number returns the number divided by 3
     */
    public double thirdDouble(double num) {
        return num / 3;
    }

    /*
     Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
     string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
     yields the empty string "". Note that str.length() returns the length of a string.
     firstTwo("Hello") → "He"
     firstTwo("abcdefg") → "ab"
     firstTwo("ab") → "ab"
     */
    public String firstTwo(String str) {

        if (str.length() < 2) return str;
        return str.substring(0, 2);
    }

    /*
    Given an array of integers, double each number in the array
     */
    public int[] doubleAllNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }
        return nums;
    }

    /*
     Given an array of Strings, return an ArrayList containing the same Strings in the same order
     except for any words that contain exactly 4 characters.
     no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
     no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
     no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
     */
    public List<String> no4LetterWords(String[] stringArray) {
        List<String> no4LetterWordList = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() != 4) {
                no4LetterWordList.add(stringArray[i]);
            }
        }
        return no4LetterWordList;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     *
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
        int petersMoney = peterPaul.get("Peter");
        int paulsMoney = peterPaul.get("Paul");

        if (petersMoney > 0 && paulsMoney < 1000) {
            int moneyToPayPaul = petersMoney / 2;
            peterPaul.put("Paul", moneyToPayPaul + paulsMoney);
            peterPaul.put("Peter", petersMoney - moneyToPayPaul);
        }

        return peterPaul;
    }






}
