package com.example.prateek.problemsolving.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

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

    /**
     * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
     *
     * @param c
     * @param k
     * @return
     */
    public int jumpingOnClouds(int[] c, int k) {

        int energy = 100;

        for (int jump = 0; jump < c.length; jump = jump + k) {
            energy -= 1;
            if (c[jump] == 1) {
                energy -= 2;
            }
        }

        return energy;
    }

    /**
     * https://www.hackerrank.com/challenges/strange-advertising/problem
     * TODO
     * This is O(n) solution. But it must have O(1) solution also.
     */
    public int viralAdvertising(int n) {

        int totalLikes = 0;

        totalLikes = 2;

        int dayShare = 2;

        for (int day = 2; day <= n; day++) {
            dayShare = dayShare * 3 / 2;
            totalLikes = totalLikes + dayShare;
        }

        return totalLikes;
    }

    /**
     * https://www.hackerrank.com/challenges/equality-in-a-array/problem
     *
     * @param arr
     * @return O(n^2) time and O(1) space solution
     */
    public int equalizeArray1(int[] arr) {

        int maxFrequency = 1;

        for (int i = 0; i < arr.length; i++) {

            int frequency = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    frequency++;
                }
            }

            if (maxFrequency < frequency) {
                maxFrequency = frequency;
            }
        }

        return arr.length - maxFrequency;
    }

    /**
     * https://www.hackerrank.com/challenges/equality-in-a-array/problem
     *
     * @param arr
     * @return O(n) time and O(n) space solution
     */
    public int equalizeArray2(int[] arr) {

        HashMap<Integer, Integer> frequencyList = new HashMap<>();

        for (int index = 0; index < arr.length; index++) {

            if (frequencyList.containsKey(arr[index])) {
                frequencyList.put(arr[index], frequencyList.get(arr[index]) + 1);
            } else {
                frequencyList.put(arr[index], 1);
            }

        }

        int maxFrequency = 0;

        for (Integer key : frequencyList.keySet()) {

            if (maxFrequency < frequencyList.get(key)) {
                maxFrequency = frequencyList.get(key);
            }

        }

        return arr.length - maxFrequency;
    }

    /**
     * TODO: Not working currently
     * https://www.hackerrank.com/challenges/equality-in-a-array/problem
     *
     * @param arr
     * @return O(n) time and O(1) space solution
     * <p>
     * This is possible because array has all values less than length;
     */
    public int equalizeArray3(int[] arr) {

        HashMap<Integer, Integer> frequencyList = new HashMap<>();

        for (int index = 0; index < arr.length; index++) {

            if (frequencyList.containsKey(arr[index])) {
                frequencyList.put(arr[index], frequencyList.get(arr[index]) + 1);
            } else {
                frequencyList.put(arr[index], 1);
            }
        }

        int maxFrequency = 0;

        for (Integer key : frequencyList.keySet()) {

            if (maxFrequency < frequencyList.get(key)) {
                maxFrequency = frequencyList.get(key);
            }
        }

        return arr.length - maxFrequency;
    }

    /**
     * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
     *
     * @param c
     * @return
     */
    public int jumpingOnClouds(int[] c) {

        int dest = 0;
        int jumps = 0;

        while (dest < c.length - 1) {

            if (dest <= c.length - 3 && c[dest + 2] != 1) {
                dest = dest + 2;
            } else {
                dest = dest + 1;
            }

            jumps++;
        }

        return jumps;
    }

    /**
     * https://www.hackerrank.com/challenges/cut-the-sticks/problem
     *
     * @param arr This could easily be reduced to finding frequencies of numbers in sorted order.
     */
    public void cutTheSticks(int[] arr) {

        Arrays.sort(arr);

        System.out.println(arr.length);

        int previous;
        int current = arr[0];
        for (int index = 1; index < arr.length; index++) {

            previous = current;
            current = arr[index];

            if (current != previous) {
                System.out.println(arr.length - index);
            }
        }
    }

    /**
     * https://www.hackerrank.com/challenges/repeated-string/problem
     *
     * @param s
     * @param n
     * @return
     */
    public long repeatedString(String s, long n) {

        long countOfA = 0;

        long lastStringLength = n % s.length();

        long aInString = 0;
        for (int index = 0; index < s.length(); index++) {

            // Here calculating total a's
            if (s.charAt(index) == 'a') {
                aInString++;

                // Here calculating a's in last string(till n)
                if (index < lastStringLength) {
                    countOfA++;
                }
            }
        }

        return countOfA + aInString * (n / s.length());
    }

    /**
     * Time complexity is very bad.
     * If T is team and t is topic
     * Time Complexity = O(t*T^2)
     * Kind of cubic complexity.
     */
    public int[] acmTeam(String[] topic) {

        int maxKnown = 0;
        int totalTeams = 0;

        // This has T^2 complexity
        for (int i = 0; i < topic.length; i++) {
            for (int j = 0; j < topic.length; j++) {

                // If same team, no need to do anything.
                if (i == j) {
                    continue;
                }

                int known = findKnown(topic[i], topic[j]);

                if (known > maxKnown) {
                    maxKnown = known;
                    totalTeams = 1;
                } else if (maxKnown == known) {
                    totalTeams++;
                }
            }
        }

        // As iterating the same pair of teams two times, so totalTeams are haved.
        return new int[]{maxKnown, totalTeams / 2};
    }

    /**
     * Time complexity is very bad.
     * If T is team and t is topic
     * Time Complexity = O(t*T^2)
     * Kind of cubic complexity.
     * Although from previous solution reduced a little to O(t*T(T+1)/2) but still O(t*T^2)
     */
    public int[] acmTeam1(String[] topic) {

        int maxKnown = 0;
        int totalTeams = 0;

        // Even this has T^2 complexity(T(T+1)/2)
        for (int i = 0; i < topic.length; i++) {
            for (int j = i; j < topic.length; j++) {

                // If same team, no need to do anything.
                if (i == j) {
                    continue;
                }

                int known = findKnown(topic[i], topic[j]);

                if (known > maxKnown) {
                    maxKnown = known;
                    totalTeams = 1;
                } else if (maxKnown == known) {
                    totalTeams++;
                }
            }
        }

        // As iterating the same pair of teams two times, so totalTeams are haved.
        return new int[]{maxKnown, totalTeams};
    }

    /**
     * If T is team and t is topic
     * Time Complexity = O(t*T + T^2) and O(T) is the space complexity
     * This is the best we can get.
     * This won't work if topic values goes beyond integer, as is the case with second test case.
     * So, we have acm1 as the best solution here.
     */
    public int[] acmTeam2(String[] topic) {

        int maxKnown = 0;
        int totalTeams = 0;

        int[] arr = new int[topic.length];
        for (int i = 0; i < topic.length; i++) {
            int index = 1;
            int total = 0;
            for (int j = topic[i].length() - 1; j >= 0; j--) {

                int value = topic[i].charAt(j) - '0';

                total = total + value * index;

                index = index * 2;
            }
            arr[i] = total;
        }

        // Even this has T^2 complexity(T(T+1)/2)
        for (int i = 0; i < topic.length; i++) {
            for (int j = i; j < topic.length; j++) {

                // If same team, no need to do anything.
                if (i == j) {
                    continue;
                }

                int known = arr[i] | arr[j];

                if (known > maxKnown) {
                    maxKnown = known;
                    totalTeams = 1;
                } else if (maxKnown == known) {
                    totalTeams++;
                }
            }
        }

        int totalKnowns = findTotalKnowns(maxKnown);

        return new int[]{totalKnowns, totalTeams};
    }

    public int findTotalKnowns(int maxKnown) {

        int totalKnowns = 0;

        while (maxKnown > 0) {

            totalKnowns = totalKnowns + (maxKnown & 1);
            maxKnown = maxKnown >> 1;
        }
        return totalKnowns;
    }

    public int findKnown(String str1, String str2) {

        int known = 0;

        for (int index = 0; index < str1.length(); index++) {
            if (str1.charAt(index) == '1' || str2.charAt(index) == '1') {
                known++;
            }
        }

        return known;
    }

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-squares/problem
     * Find total perfect squares between a and b.
     * Here we are using the property of odd sum,
     * ie If we keep on adding add numbers from series, we get square
     * 1 + 3 + 5 + 7 = 16,,,,,so on
     *
     * @param a
     * @param b
     * @return
     */
    public int squares(int a, int b) {

        int total = 0;
        int current = 1;

        int totalSquares = 0;
        while (total <= b) {
            total = total + current;
            if (total >= a && total <= b) {
                totalSquares++;
            }
            current = current + 2;
        }

        return totalSquares;
    }

    /**
     * TODO
     * Complexity is O(n^2), time could be reduced by having O(n) space complexity I guess.
     **/
    static int minimumDistances(int[] a) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j] && Math.abs(i - j) < min) {
                    min = Math.abs(i - j);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * TODO
     * https://www.hackerrank.com/challenges/service-lane/problem
     * O(n^2) solution, could be better.
     **/
    public int[] serviceLane(int[] width, int[][] cases) {

        int[] arr = new int[cases.length];

        for (int i = 0; i < cases.length; i++) {

            int start = cases[i][0];
            int end = cases[i][1];

            int min = width[start];
            for (int j = start; j <= end; j++) {
                if (width[j] < min) {
                    min = width[j];
                }
            }

            arr[i] = min;
        }

        return arr;
    }

    /**
     * https://www.hackerrank.com/challenges/cavity-map/problem
     *
     * @param grid
     * @return
     */
    public String[] cavityMap(String[] grid) {

        String[] result = new String[grid.length];

        result[0] = grid[0];

        for (int i = 1; i < grid.length - 1; i++) {

            StringBuilder currentStr = new StringBuilder();
            currentStr.append(grid[i].charAt(0));
            for (int j = 1; j < grid[i].length() - 1; j++) {
                int current = grid[i].charAt(j);
                if (current > grid[i].charAt(j - 1) &&
                        current > grid[i].charAt(j + 1) &&
                        current > grid[i - 1].charAt(j) &&
                        current > grid[i + 1].charAt(j)) {
                    currentStr.append('X');
                } else {
                    currentStr.append(grid[i].charAt(j));
                }
            }

            if (currentStr.length() < grid[i].length()) {
                currentStr.append(grid[i].charAt(grid[i].length() - 1));
            }

            result[i] = currentStr.toString();
        }

        result[grid.length - 1] = grid[grid.length - 1];

        return result;
    }

    public int findRoot(int num) {

        int odd = 1;
        int sqrt = 1;
        int square = 1;
        while (square < num) {
            sqrt++;
            odd += 2;
            square += odd;
        }

        return sqrt;
    }

    /**
     * https://www.hackerrank.com/challenges/encryption/problem
     *
     * @param s
     * @return
     */
    public String encryption(String s) {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != 32) {
                str.append(s.charAt(i));
            }
        }

        double sq = Math.sqrt(str.length());

        // r value only needed to finalize the c value.
        int r = (int) Math.floor(sq);
        int c = (int) Math.ceil(sq);

        if (r * c < str.length()) {

            if (r == c) {
                c = c + 1;
            } else {
                // This will make length bigger now, though not required.
                r = r + 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < c; i++) {

            for (int j = i; j < str.length(); j = j + c) {
                result.append(str.charAt(j));
            }

            result.append(" ");
        }

        return result.toString();
    }


    /**
     * https://www.hackerrank.com/challenges/picking-numbers/problem
     * <p>
     * TODO This is more like brute force way of achieving this in O(n^2) time.
     * Could be optimized, and done in O(n) time by maitaining some values.
     *
     * @param a
     * @return
     */
    public int pickingNumbers(int[] a) {

        Arrays.sort(a);

        int maxNum = 0;

        for (int i = 0; i < a.length; i++) {

            int currNum = 0;

            for (int j = i + 1; j < a.length; j++) {

                if (a[j] - a[i] < 2) {
                    currNum++;
                } else {
                    break;
                }

            }

            if (currNum > maxNum) {
                maxNum = currNum;
            }
        }

        return maxNum;
    }

}