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

    @Test
    public void testAcmICPCTeam() {

        String[] str = new String[]{"10101",
                "11100",
                "11010",
                "00101"};

        assertEquals(null, implementation.acmTeam2(str));

    }

    @Test
    public void testSqrt() {
        assertEquals(4, implementation.findRoot(16));
        assertEquals(7, implementation.findRoot(49));
        assertEquals(7, implementation.findRoot(54));
        assertEquals(8, implementation.findRoot(80));
    }

    @Test
    public void testEncryption() {

        String s = "haveaniceday";
        String str = implementation.encryption(s);

        assertEquals("hae and via ecy", str);
    }
}