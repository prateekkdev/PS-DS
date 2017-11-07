package com.example.prateek.problemsolving;

import org.junit.Test;

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

        assertEquals(40, (long) list.findAt(2));
    }

    @Test
    public void testFindAtIndexNegative() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(null, list.findAt(7));
    }

    @Test
    public void testFindFirstPositive() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(50, (long) list.findFirst());
    }

    @Test
    public void testFindFirstNegative() {
        PLinkedList<Integer> list = new PLinkedList<>();
        assertEquals(null, list.findFirst());
    }

    @Test
    public void testFindLastPositive() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(10, (long) list.findLast());
    }

    @Test
    public void testFindLastNegative() {
        PLinkedList<Integer> list = new PLinkedList<>();
        assertEquals(null, list.findLast());
    }

    @Test
    public void testIsDataPositive() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        assertThat(true, is(list.isData(20)));
    }


    @Test
    public void testIsDataNegative() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        assertThat(false, is(list.isData(1320)));
    }

    @Test
    public void testAddFirst() {

        PLinkedList<Integer> list = new PLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        assertThat(40, is(list.findFirst()));
    }

    @Test
    public void testAddLast() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertThat(10, is(list.findFirst()));
    }

    @Test
    public void testRemoveFirst() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.removeFirst();
        assertThat(20, is(list.findFirst()));
    }

    @Test
    public void testRemoveLast() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.removeLast();
        assertThat(20, is(list.findLast()));
    }

    @Test
    public void testRemoveData() {
        PLinkedList<Integer> list = new PLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.remove(30);

        assertThat(false, is(list.isData(30)));
    }
}