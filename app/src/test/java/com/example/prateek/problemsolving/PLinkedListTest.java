package com.example.prateek.problemsolving;

import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by prateek on 6/11/17.
 */
public class PLinkedListTest {

    @Test
    public void testFindAtIndexPositive() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(40, (long) list.find(2));
    }

    @Test
    public void testFindAtIndexNegative() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(null, list.find(7));
    }

    @Test
    public void findFirstPositive() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(50, (long) list.findFirst());
    }

    @Test
    public void findFirstNegative() {
        PLinkedList<Integer> list = new PLinkedList<>();
        assertEquals(null, list.findFirst());
    }

    @Test
    public void findLastPositive() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(10, (long) list.findLast());
    }

    @Test
    public void findLastNegative() {
        PLinkedList<Integer> list = new PLinkedList<>();
        assertEquals(null, list.findLast());
    }
}