package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CigarPartyTest {
    private CigarParty party;
    private final String errorMessage1 = "During weekdays, below 40 cigars should return false.";
    private final String errorMessage2 = "During weekdays, between 40 and 60 cigars should return true.";
    private final String errorMessage3 = "During weekends, there's no upper limit on cigars.";

    @Before
    public void initialize() {
        party = new CigarParty();
        System.out.println("Beginning Setup");
    }

    @Test
    public void CigarParty_haveParty_return_boolean_true_for_weekday_and_cigars_in_40_to_60_range() {
        int cigars = 40;
        boolean isWeekend = false;
        boolean result = party.haveParty(cigars, isWeekend);
        Assert.assertEquals(errorMessage2, true, result);
    }

    @Test
    public void CigarParty_haveParty_return_boolean_true_for_weekday_and_cigars_below_40() {
        int cigars = 60;
        boolean isWeekend = false;
        boolean result = party.haveParty(cigars, isWeekend);
        Assert.assertEquals(errorMessage1, true, result);
    }

    @Test
    public void CigarParty_haveParty_return_boolean_false_for_weekday_and_cigars_above_60() {
        int cigars = 61;
        boolean isWeekend = false;
        boolean result = party.haveParty(cigars, isWeekend);
        Assert.assertEquals(errorMessage1, false, result);
    }

    @Test
    public void CigarParty_haveParty_return_boolean_false_for_weekend_and_cigars_below_40() {
        int cigars = 39;
        boolean isWeekend = true;
        boolean result = party.haveParty(cigars, isWeekend);
        Assert.assertEquals(errorMessage1, false, result);
    }

    @Test
    public void CigarParty_haveParty_return_boolean_true_for_weekend_and_cigars_above_60() {
        int cigars = 70;
        boolean isWeekend = true;
        boolean result = party.haveParty(cigars, isWeekend);
        Assert.assertEquals(errorMessage3, true, result);
    }
}

