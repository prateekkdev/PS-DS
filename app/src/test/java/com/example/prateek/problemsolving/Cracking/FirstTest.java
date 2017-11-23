package com.example.prateek.problemsolving.Cracking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prateek on 22/11/17.
 */

public class FirstTest {

    First first;

    @Before
    public void init() {
        first = new First();
    }

    @Test
    public void testIsPermutation_ValidEmpty() {
        assertEquals(true, first.isPermutation("", ""));
    }

    @Test
    public void testIsPermutation_ValidSmall() {
        assertEquals(true, first.isPermutation("ab", "ab"));
    }

    @Test
    public void testIsPermutation_ValidLarge() {
        assertEquals(true, first.isPermutation("abcdefg", "gfedcba"));
    }

    @Test
    public void testIsPermutation_ValidSmallRepeating() {
        assertEquals(true, first.isPermutation("aaa", "aaa"));
    }

    @Test
    public void testIsPermutation_ValidLargeRepeating() {
        assertEquals(true, first.isPermutation("ababababab", "bababababa"));
    }

    @Test
    public void testIsPermutation_InvalidDifferentSize() {
        assertEquals(false, first.isPermutation("abc", "ab"));
    }

    @Test
    public void testIsPermutation_InvalidSmall() {
        assertEquals(false, first.isPermutation("abc", "abg"));
    }

    @Test
    public void testIsPermutation_InvalidLarge() {
        assertEquals(false, first.isPermutation("abcdefghi", "abcdefgdi"));
    }
}