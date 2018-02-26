package com.example.prateek.problemsolving.hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

/**
 * Created by admin on 2/26/18.
 */

public class ImplementationTest {

    private Implementation implementation;

    @Before
    public void init() {
        implementation = new Implementation();
    }

    @Test
    public void testFact() {
        assertEquals(120, implementation.fact(new BigInteger("5")));
    }

    @Test
    public void testReverseDay() {
        assertEquals(12548, implementation.reversedDay(84521));
    }
}