package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {
        CigarParty party;

    @Before
    public void beginSetup(){
        party = new CigarParty();
        System.out.println("Beginning Setup");
    };

    @Test
    public void CigarParty_returns_boolean_test(){
        //Tests Boolean between 40 and 60, inclusive.
        //Unless it is the weekend, no upperbound
        //(int cigars, boolean isWeekend)


        //Step 1: Arrange
        //During the weekday
        int weekdayExclusiveBelowEdgeCase = 40;
        int weekdayExclusiveAboveEdgeCase = 60;
        //During the weekend
        int weekendExclusiveBelowEdgeCase = weekdayExclusiveBelowEdgeCase;

        //Step 2: Act
        //Tests Boolean between 40 and 60, inclusive.
        boolean test1 = party.haveParty(weekdayExclusiveBelowEdgeCase, false);
        boolean test2 = party.haveParty(weekdayExclusiveAboveEdgeCase, false);
        //Outside of inclusive.
        boolean test3 = party.haveParty(weekdayExclusiveBelowEdgeCase - 1, false);
        boolean test4 = party.haveParty(weekdayExclusiveAboveEdgeCase + 1, false);
        //Weekend Test
        boolean test5 = party.haveParty(weekendExclusiveBelowEdgeCase, true);

        //Step 3: Assert
        String errorMessagePlain = "Expected False, Sorry please try again\n";
//                "Please double check you are at the right cigar party and try your cigar again. ";

        String errorMessage1 = "Hey there! It looks like the squirrel party might not be a hit this time around. " +
                "Remember, during the weekdays they prefer between 40 and 60 cigars. " +
                "Let's try that range, shall we? 😊";

        String errorMessage2 = "Oops! It seems our squirrel friends " +
                "might be a bit short on cigars for their weekday bash. " +
                "Let's make sure they have between 40 and 60 cigars for the best party vibes! 🎉";

        String errorMessage3 = "Hold on! The squirrel party isn't booming just yet. " +
                "If it's the weekend, there's no limit on the fun! But on weekdays, " +
                "40 to 60 cigars make it perfect. Let's adjust and party on! 🐿️🎈";


        Assert.assertEquals(errorMessage1, test1, true);
        Assert.assertEquals(errorMessage1, test2, true);
        Assert.assertEquals(errorMessage1, test3, false);
        Assert.assertEquals(errorMessage2, test4, false);
        Assert.assertEquals(errorMessage3, test5, true);
    };
}
