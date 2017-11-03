package com.example.prateek.problemsolving;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.SSLContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by prateek on 2/11/17.
 */

public class ProblemsTest {

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
}