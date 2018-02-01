package com.example.prateek.problemsolving.hackerrank;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by admin on 1/31/18.
 */

public class ChallengesStringsTest {

    ChallengesStrings challengesStrings;

    @Before
    public void init() {
        challengesStrings = new ChallengesStrings();
    }

    @Test
    public void testPangram() {
        assertEquals("pangram", challengesStrings.checkPangram("We promptly judged antique ivory buckles for the next prize    \n"));
        assertEquals("not pangram", challengesStrings.checkPangram("We promptly judged antique ivory buckles for the prize    \n"));
    }

    @Test
    public void testCheckHackerrank() {
        assertEquals("YES", challengesStrings.checkHackerrank("hereiamstackerrank"));
        assertEquals("NO", challengesStrings.checkHackerrank("hackerworld"));
    }

    @Test
    public void testFunnyString() {

        assertEquals("Funny", challengesStrings.funnyString("acxz"));
        assertEquals("Not Funny", challengesStrings.funnyString("bcxz"));

    }

    @Test
    public void testGemStones() {
        assertEquals(1, challengesStrings.gemStones(new String[]{"adde","abcdde", "baccd", "eecabg"}));
        assertEquals(2, challengesStrings.gemStones(new String[]{"abcdde", "baccd", "eeabg"}));
        assertEquals(3, challengesStrings.gemStones(new String[]{"abcdde", "baccd", "eecabg"}));
    }

    @Test
    public void testMakingAnagrams() {
        assertEquals(4, challengesStrings.makingAnagrams("abc", "cde"));
    }
}