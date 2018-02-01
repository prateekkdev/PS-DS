package com.example.prateek.problemsolving.hackerrank;

/**
 * Created by admin on 1/31/18.
 */

public class Warmup {

    /**
     *
     * Plus, minus, zero fractions in an array of integers.
     *
     * https://www.hackerrank.com/challenges/plus-minus/problem
     * @param arr
     */
    public void plusMinus(int[] arr) {

        int total = arr.length;
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int index = 0; index < total; index++) {
            if (arr[index] > 0) {
                positive++;
            } else if (arr[index] < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.println((float) positive / total);
        System.out.println((float) negative / total);
        System.out.println((float) zero / total);
    }

    /**
     *
     * Find cound of bigget numbers in array.
     *
     * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     * @param n
     * @param arr
     * @return
     */
    public int birthdayCakeCandles(int n, int[] arr) {

        int max = 0;

        for(int index = 1; index < arr.length; index++) {
            if(arr[index] > max) {
                max = arr[index];
            }
        }

        int totalMax = 0;

        for(int index = 0; index < arr.length; index++) {
            if(arr[index] == max) {
                totalMax++;
            }
        }

        return totalMax;
    }

}
