package com.example.prateek.problemsolving.Cracking;

import java.util.HashMap;

/**
 * Created by prateek on 22/11/17.
 */

public class First {

    public boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            char c = str1.charAt(i);

            int count = 0;
            if (map.containsKey(c)) {
                count = map.get(c) + 1;
            } else {
                count = 1;
            }
            map.put(c, count);
        }

        for (int i = 0; i < str2.length(); i++) {

            char c = str2.charAt(i);

            Integer count = map.get(c);

            if (count == null || count == 0) {
                return false;
            }

            map.put(c, --count);
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindromePermutation(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            int count = 1;
            if (map.containsKey(c)) {
                count = map.get(c) + count;
            }

            map.put(c, count);
        }

        // If no odd or only one odd, then only palindrome

        boolean isFoundOdd = false;

        for (int count : map.values()) {

            if (count % 2 == 1) {

                if (isFoundOdd) {
                    return false;
                }

                isFoundOdd = true;
            }
        }

        return true;
    }
}
