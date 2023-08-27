package org.example.tema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AthleteTest {

    private Athlete athlete;

    @Before
    public void setUp() {
        athlete = new Athlete("1", "Laurence Taylor", CountryCode.US,
                "25:45", "xxoxo", "ooxxo", "xxxoo");
    }

    @After
    public void tearDown() {
        athlete = null;
    }

    @Test
    public void testGetPenalty() {
        int penalty = athlete.getPenalty();
        Assert.assertEquals(70, penalty);
    }

    @Test
    public void testGetTotalTime() {
        int totalTime = athlete.getTotalTime();
        Assert.assertEquals(1615, totalTime);
    }
}