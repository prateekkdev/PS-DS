package com.example.prateek.problemsolving;

import android.support.v4.util.Pair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.SSLContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by prateek on 2/11/17.
 */

public class ChessProblemsTest {

    @Test
    public void firstProblem() {
        System.out.println("Result");
    }

    @Test
    public void testFindSubsets() {

        ArrayList<Integer> total = new ArrayList<>();
        total.add(2);

        String current = "";

        subset(total, current, 0);
    }

    public static int count = 0;

    public void subset(ArrayList<Integer> total, String current, int c) {

        System.out.println("Count: " + ++count);

        if (c < total.size()) {
            subset(total, current, c + 1);
            current = current + total.get(c) + ",";
            subset(total, current, c + 1);
        } else {
            printStr(current);
        }
    }

    public void printStr(String str) {
        System.out.print("{" + str + "}");
    }

    @Test
    public void testFlattenObjects() {

        // { 1, 3, {2, 3, 5}, "abc", 20, 30, {{"a", "b"}, 200, 300}, {"a", "f", 10}}

        // { 1, 3, 2, 3, 5, "abc", 20, 30, "a", "b", 200, 300, "a", "f", 10 }


        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(3);

        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);

        list.add(list1);

        list.add("abc");
        list.add(20);
        list.add(30);

        ArrayList<Object> list2 = new ArrayList<>();

        ArrayList<Object> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");

        list2.add(list3);
        list2.add(200);
        list2.add(300);

        list.add(list2);

        ArrayList<Object> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("f");
        list4.add(10);

        list.add(list4);

        System.out.println("Non Flatten: ");
        printArrayList(list);

        flattenObjects(list);

        System.out.println("\n\nFlatten: ");
        printArrayList(newList);

    }

    ArrayList<Object> newList = new ArrayList<>();

    public void flattenObjects(ArrayList<Object> list) {

        for (Object o : list) {

            if (o instanceof ArrayList) {
                flattenObjects((ArrayList) o);
            } else {
                newList.add(o);
            }

        }
    }

    void printArrayList(ArrayList<Object> list) {

        System.out.print("{");

        for (int index = 0; index < list.size(); index++) {

            Object o = list.get(index);

            if (o instanceof ArrayList) {
                printArrayList((ArrayList) o);
            } else {
                System.out.print(o);
            }

            if (index != list.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("}");
    }


    @Test
    public void testFibNormal() {

        System.out.println("Fib 0: " + fib(0));

        System.out.println("Fib 3: " + fib(3));

        System.out.println("Fib 10: " + fib(10));

        System.out.println("Fib 10: " + fib(45));
    }

    public int fib(int num) {

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        return fib(num - 1) + fib(num - 2);
    }

    @Test
    public void testFibDP() {
        System.out.println("Fib 0: " + fibDP(0));

        System.out.println("Fib 3: " + fibDP(3));

        System.out.println("Fib 10: " + fibDP(10));

        System.out.println("Fib 10: " + fibDP(45));
    }

    public int fibDP(int num) {

        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, 0);
        mem.put(1, 1);

        return fibDP(num, mem);
    }

    private int fibDP(int num, HashMap<Integer, Integer> mem) {

        if (mem.containsKey(num)) {
            return mem.get(num);
        }

        int current = fibDP(num - 1, mem) + fibDP(num - 2, mem);

        mem.put(num, current);

        return current;
    }

    @Test
    public void testSumDigits() {
        assertEquals(10, sumDigits(145));
        assertEquals(32, sumDigits(8987));
        assertEquals(3, sumDigits(3));
        assertEquals(0, sumDigits(0));
    }

    public int sumDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return num % 10 + sumDigits(num / 10);
    }

    @Test
    public void testFactorial() {

        assertEquals(1, fact(0));
        assertEquals(1, fact(1));
        assertEquals(120, fact(5));
        assertEquals(40320, fact(8));

    }

    public int fact(int num) {
        if (num == 0) {
            return 1;
        }
        return num * fact(num - 1);
    }

    @Test
    // http://codingbat.com/prob/p183649
    public void testBunnyEars() {
        assertEquals(0, bunnyEars(0));
        assertEquals(2, bunnyEars(1));
        assertEquals(10, bunnyEars(5));
        assertEquals(50, bunnyEars(25));
    }

    public int bunnyEars(int bunnies) {

        if (bunnies == 0) {
            return 0;
        }

        return 2 + bunnyEars(bunnies - 1);
    }

    @Test
    // http://codingbat.com/prob/p107330
    public void testBunnies2() {
        assertEquals(0, bunnyEars2(0));
        assertEquals(2, bunnyEars2(1));
        assertEquals(5, bunnyEars2(2));
        assertEquals(22, bunnyEars2(9));
        assertEquals(25, bunnyEars2(10));
    }

    public int bunnyEars2(int bunnies) {

        if (bunnies == 0) {
            return 0;
        }

        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        }

        return 2 + bunnyEars2(bunnies - 1);

    }

    @Test
    // http://codingbat.com/prob/p194781
    public void testTriangle() {
        assertEquals(0, triangleBlocks(0));
        assertEquals(1, triangleBlocks(1));
        assertEquals(3, triangleBlocks(2));
        assertEquals(6, triangleBlocks(3));
        assertEquals(10, triangleBlocks(4));
        assertEquals(15, triangleBlocks(5));
        assertEquals(21, triangleBlocks(6));
    }

    /**
     * f(n) = n + f(n-1)
     *
     * @param row
     * @return
     */
    public int triangleBlocks(int row) {

        if (row == 0) {
            return 0;
        }

        return row + triangleBlocks(row - 1);
    }

    @Test
    // http://codingbat.com/prob/p101409
    public void testCount7() {

        assertEquals(0, count7(18934));
        assertEquals(0, count7(0));
        assertEquals(1, count7(7));
        assertEquals(2, count7(77));
        assertEquals(2, count7(8707));
        assertEquals(5, count7(77777));
        assertEquals(2, count7(7170008));
    }

    private int count7(int num) {

        if (num == 0) {
            return 0;
        }

        return (num % 10 == 7 ? 1 : 0) + count7(num / 10);
    }

    @Test
    // http://codingbat.com/prob/p192383
    public void testCount8() {

        assertEquals(0, count8(0));
        assertEquals(0, count8(0));
        assertEquals(1, count8(8907));
        assertEquals(1, count8(8));
        assertEquals(3, count8(88));
        assertEquals(2, count8(8989));
        assertEquals(5, count8(898878));

    }

    public int count8(int num) {
        return getCountOf8(num).second;
    }

    public Pair<Boolean, Integer> getCountOf8(int num) {

        if (num == 0) {
            return new Pair<>(false, 0);
        }

        Pair<Boolean, Integer> prev = getCountOf8(num / 10);

        int value = prev.second;
        if (prev.first && num % 10 == 8) {
            value = value + 2;
        } else if (num % 10 == 8) {
            value = value + 1;
        }

        return new Pair<>(num % 10 == 8, value);
    }

    @Test
    // http://codingbat.com/prob/p158888
    public void testPowerN() {

        assertEquals(1, powerN(3, 0));
        assertEquals(1, powerN(1, 5));
        assertEquals(0, powerN(0, 0));
        assertEquals(4, powerN(2, 2));
        assertEquals(81, powerN(3, 4));

    }

    public int powerN(int n, int m) {

        if (n == 0) {
            return 0;
        }

        if (m == 0) {
            return 1;
        }

        return n * powerN(n, m - 1);

    }

    @Test
    public void testCountX() {

        assertEquals(0, countX("hello"));
        assertEquals(1, countX("GoogleX"));
        assertEquals(1, countX("xXx"));
        assertEquals(3, countX("HellNoXXDptxX"));

    }

    public int countX(String str) {
        return getCountX(str, 0);
    }

    public int getCountX(String str, int currentChar) {

        if (currentChar >= str.length()) {
            return 0;
        }

        return (str.charAt(currentChar) == 'X' ? 1 : 0) + getCountX(str, ++currentChar);
    }

    @Test
    public void testCountHi() {
        assertEquals(0, countHi("hello"));
        assertEquals(0, countHi(""));
        assertEquals(0, countHi("HI"));
        assertEquals(1, countHi("Hi"));
        assertEquals(1, countHi("Hi5"));
        assertEquals(3, countHi("helloHihelloHiByeAgainHiThere"));
    }

    public int countHi(String str) {
        return getCountHi(str, 0);
    }

    public int getCountHi(String str, int currentChar) {

        // We ought to see two chars in the end.
        if (currentChar >= str.length() - 1) {
            return 0;
        }

        return (str.charAt(currentChar) == 'H' && str.charAt(currentChar + 1) == 'i' ? 1 : 0)
                + getCountHi(str, ++currentChar);
    }

    @Test
    public void testChangeXY() {

        assertEquals("hey", changeXY("hey"));
        assertEquals("y-mas", changeXY("x-mas"));
        assertEquals("yyy", changeXY("yxy"));
        assertEquals("h", changeXY("h"));
        assertEquals("yyy", changeXY("xxx"));
        assertEquals("yXy", changeXY("xXx"));

    }

    public String changeXY(String str) {
        return changeXY(new StringBuilder(str), 0).toString();
    }

    public StringBuilder changeXY(StringBuilder str, int curr) {

        if (curr >= str.length()) {
            return str;
        }

        if (str.charAt(curr) == 'x') {
            str.setCharAt(curr, 'y');
        }

        return changeXY(str, ++curr);
    }

    @Test
    public void testChangePi() {
        assertEquals("", changePi(""));
        assertEquals("hey", changePi("hey"));
        assertEquals("3.14", changePi("pi"));
        assertEquals("3.143.14", changePi("pipi"));
        assertEquals("hey3.14hello", changePi("heypihello"));
        assertEquals("heyheyhey", changePi("heyheyhey"));
        assertEquals("hey3.14", changePi("heypi"));
    }

    public String changePi(String str) {
        return getChangePi(new StringBuilder(str), 0).toString();
    }

    public StringBuilder getChangePi(StringBuilder str, int curr) {

        if (curr >= str.length() - 1) {
            return str;
        }

        if (str.charAt(curr) == 'p' && str.charAt(curr + 1) == 'i') {
            str.replace(curr, curr + 2, "3.14");
            return getChangePi(str, curr + 4);
        } else {
            return getChangePi(str, ++curr);
        }
    }

    @Test
    public void testKthLastElementLinkedList() {


    }

    @Test
    public void testEndX() {
        assertEquals("", endX(""));
        assertEquals("hey", endX("hey"));
        assertEquals("s-max", endX("x-mas"));
        assertEquals("oheylhelxxx", endX("xheyxhellox"));
    }

    public String endX(String str) {

        if (str.length() == 0) {
            return str;
        }

        int last = findLast(str, 'x', str.length() - 1);

        return getEndX(new StringBuilder(str), 0, last).toString();
    }

    public int findLast(String str, char c, int last) {

        if (last == 0) {
            return 0;
        }

        if (str.charAt(last) == c) {
            return findLast(str, c, last - 1);
        }

        return last;
    }

    public StringBuilder getEndX(StringBuilder str, int first, int last) {

        if (first > last) {
            return str;
        }

        if (str.charAt(first) == 'x') {
            swap(str, first, last--);
        }

        return getEndX(str, ++first, last);
    }

    public StringBuilder swap(StringBuilder str, int index1, int index2) {

        char c = str.charAt(index1);

        str.setCharAt(index1, str.charAt(index2));
        str.setCharAt(index2, c);

        return str;
    }

    @Test
    public void testFindAllPath() {

        assertEquals(0, path(new boolean[][]{}));

        assertEquals(1, path(new boolean[][]{
                {true}
        }));

        assertEquals(1, path(new boolean[][]{
                {true, true},
                {false, true}
        }));

        assertEquals(2, path(new boolean[][]{
                {true, true},
                {true, true}
        }));

        assertEquals(0,
                path(new boolean[][]{
                        {true, false, true},
                        {true, false, true},
                        {true, false, true}}));

        assertEquals(1, path(new boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, false, true}
        }));

        assertEquals(2, path(new boolean[][]{
                {true, true, true},
                {true, false, true},
                {true, true, true}
        }));

        assertEquals(6, path(new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        }));

        assertEquals(2, path(new boolean[][]{
                {true, true, true},
                {true, false, true},
                {true, false, true},
                {true, true, true}
        }));

        assertEquals(11009376, path(new boolean[][]{

                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, true, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, true, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, true, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, true, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, true, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, false, false, true, false, true, true, false, true, false, true, false, true, false},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        }));

    }

    class Block {
        int row;
        int col;

        Block(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            Block block = (Block) obj;
            if (block.row == row && block.col == col) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return row;
        }
    }

    private HashMap<Block, Integer> mem = new HashMap();

    public long path(boolean[][] arr) {
        mem.clear();
        return getPath(arr, 0, 0);
    }

    private int getPath(boolean[][] arr, int r, int c) {

        if (!isValid(arr, r, c)) {
            return 0;
        }

        if (r == arr.length - 1 && c == arr[r].length - 1) {
            return 1;
        }

        Block block = new Block(r, c);

        if (mem.containsKey(block)) {
            return mem.get(block);
        } else {
            int path = getPath(arr, r + 1, c) + getPath(arr, r, c + 1);
            mem.put(block, path);
            return path;
        }
    }

    private boolean isValid(boolean[][] arr, int r, int c) {
        if (r < arr.length && c < arr[r].length && arr[r][c]) {
            return true;
        }
        return false;
    }
}