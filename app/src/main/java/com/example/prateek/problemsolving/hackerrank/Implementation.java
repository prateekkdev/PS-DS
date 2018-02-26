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
}