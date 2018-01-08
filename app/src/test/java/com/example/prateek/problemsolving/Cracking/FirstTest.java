package com.example.prateek.problemsolving.Cracking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prateek on 22/11/17.
 */

public class FirstTest {

    private First first;

    @Before
    public void init() {
        first = new First();
    }


    // *** Permutation Test ****

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


    // *** PalindromPermutation Test ***

    @Test
    public void testIsPalindromePermutation_Empty() {
        assertEquals(true, first.isPalindromePermutation(""));
    }

    @Test
    public void testIsPalindromePermutation_Success_Small_NoOdd() {
        assertEquals(true, first.isPalindromePermutation("aabb"));
    }

    @Test
    public void testIsPalindromePermutation_Success_Small_OneOdd() {
        assertEquals(true, first.isPalindromePermutation("aab"));
    }

    @Test
    public void testIsPalindromePermutation_Success_Large_NoOdd() {
        assertEquals(true, first.isPalindromePermutation("aabbddddbbcccccc"));
    }


    @Test
    public void testIsPalindromePermutation_Success_Large_OneOdd() {
        assertEquals(true, first.isPalindromePermutation("aabbddgggddbbcccccc"));
    }

    @Test
    public void testIsPalindromePermutation_Failure_Small() {
        assertEquals(false, first.isPalindromePermutation("ab"));
    }

    @Test
    public void testIsPalindromePermutation_Failure_Large() {
        assertEquals(false, first.isPalindromePermutation("abcdefabcdefabcdddd"));
    }
}