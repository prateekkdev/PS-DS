package com.example.prateek.problemsolving;

import org.junit.Test;

import java.util.ArrayList;

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
}