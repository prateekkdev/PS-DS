package com.example.prateek.problemsolving.hackerrank;

import java.math.BigInteger;

/**
 * Created by admin on 2/26/18.
 */

public class Implementation {

    // https://www.hackerrank.com/challenges/extra-long-factorials/problem
    public void extraLongFactorial(int n) {

        System.out.println(fact(new BigInteger(n + "")));

    }

    public BigInteger fact(BigInteger n) {

        if (n.compareTo(new BigInteger("0")) == 0) {
            return new BigInteger("1");
        }

        return n.multiply(fact(n.subtract(new BigInteger("1"))));
    }

    public long fact(long n) {

        if (n == 0) {
            return 1;
        }

        return n * fact(n - 1);
    }

    /**
     * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
     */
    public int beautifulDays(int i, int j, int k) {

        int total = 0;

        for (int day = i; day <= j; day++) {
            if (isBeautiful(day, k)) {
                total++;
            }
        }

        return total;
    }

    public boolean isBeautiful(int day, int k) {

        if ((day - reversedDay(day)) % k == 0) {
            return true;
        }

        return false;

    }

    public int reversedDay(int day) {
        int reverse = day % 10;
        day = day / 10;

        while (day > 0) {
            reverse = reverse * 10 + (day % 10);
            day = day / 10;
        }

        return reverse;
    }

}