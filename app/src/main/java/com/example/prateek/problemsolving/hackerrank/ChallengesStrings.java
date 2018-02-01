package com.example.prateek.problemsolving.hackerrank;

/**
 * Created by admin on 1/31/18.
 */

public class ChallengesStrings {

    public String superReducedString(StringBuilder str) {

        int current = 0;
        int next = 1;

        while (next < str.length()) {

            if (str.charAt(current) == str.charAt(next)) {

                if (current == 0) {
                    // current =
                }

            }


        }


        return null;

    }

    /**
     * Mars Exploration
     * https://www.hackerrank.com/challenges/mars-exploration/problem
     *
     * @param str
     * @return
     */
    public int marsExploration(String str) {

        int totalErrors = 0;
        for (int index = 0; index < str.length(); index++) {

            if (index % 3 == 0 || index % 3 == 2) {
                if (str.charAt(index) != 'S') {
                    totalErrors++;
                }
            }
            if (index % 3 == 1) {
                if (str.charAt(index) != 'O') {
                    totalErrors++;
                }
            }
        }

        return totalErrors;

    }


    /**
     * Pangrams
     * https://www.hackerrank.com/challenges/pangrams/problem
     * <p>
     * TODO: BitVectors could easily be utlized as only boolean is needed to store, reducing space(although constant space is reduced)
     */
    public String checkPangram(String str) {

        int[] charInstances = new int[26];

        for (int index = 0; index < charInstances.length; index++) {
            charInstances[index] = 0;
        }

        for (int index = 0; index < str.length(); index++) {

            char currentChar = str.charAt(index);

            int currentCharPosition = currentChar >= 'A' && currentChar <= 'Z' ? currentChar - 'A' : (currentChar >= 'a' && currentChar <= 'z' ? currentChar - 'a' : -1);

            if (currentCharPosition == -1) {
                continue;
            }

            charInstances[currentCharPosition]++;
        }

        for (int index = 0; index < charInstances.length; index++) {
            if (charInstances[index] == 0) {
                return "not pangram";
            }
        }

        return "pangram";
    }


    /**
     * Check hackerrank in string
     * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
     *
     * @param str
     * @return
     */
    public String checkHackerrank(String str) {

        String base = "hackerrank";
        int current = 0;


        for (int index = 0; index < str.length(); index++) {

            if (str.charAt(index) == base.charAt(current)) {
                current++;
            }

            if (current == base.length()) {
                return "YES";
            }

        }

        return "NO";
    }

    /**
     * Funnly string find
     * https://www.hackerrank.com/challenges/funny-string/problem
     * <p>
     * prob
     *
     * @param str
     * @return
     */
    public String funnyString(String str) {

        for (int start = 0, end = str.length() - 1; start < str.length() - 1; start++, end--) {
            if (Math.abs(str.charAt(start + 1) - str.charAt(start)) != Math.abs(str.charAt(end - 1) - str.charAt(end))) {
                return "Not Funny";
            }
        }

        return "Funny";
    }

    /**
     * Find common character in strings.
     * <p>
     * https://www.hackerrank.com/challenges/gem-stones/problem
     * <p>
     * 3
     * abcdde - O(n)
     * baccd - O(n)
     * eeabg - O(n)
     *
     * @param arr
     * @return
     */
    public int gemStones(String[] arr) {

        int[][] charCountArr = new int[arr.length][26];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                charCountArr[i][arr[i].charAt(j) - 'a']++;
            }
        }

        int totalGems = 0;

        for (int j = 0; j < 26; j++) {

            boolean zeroInColumn = false;

            for (int i = 0; i < arr.length; i++) {
                if (charCountArr[i][j] == 0) {
                    zeroInColumn = true;
                    break;
                }
            }

            if (!zeroInColumn) {
                totalGems++;
            }
        }


        return totalGems;
    }

}