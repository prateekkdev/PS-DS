package com.example.prateek.problemsolving.Cracking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by admin on 1/30/18.
 */

public class SixthTest {

    private Sixth sixth;

    @Before
    public void initTest() {
        sixth = new Sixth();
    }

    @Test
    public void testIsGirl() {
        assertEquals(true, sixth.isGirl());
    }

    @Test
    public void testRatioAfterBabiesTillGirl() {

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(99)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(100)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(449)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(1000)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(7898)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(10000)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(32980)));

        assertEquals(1, Math.round(sixth.ratioAfterBabiesTillGirl(100000)));
    }


}
