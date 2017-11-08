package com.example.prateek.problemsolving;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by prateek on 7/11/17.
 */

public class PStackTest {

    @Test
    public void testPush() {

        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, (long) stack.peek());
    }

    @Test
    public void testPop() {

        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, (long) stack.pop());

        assertEquals(20, (long) stack.peek());
    }

    @Test
    public void testPeekPositive() {

        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(40, (long) stack.peek());
    }

    @Test
    public void testPeekNegative() {

        PStack<Integer> stack = new PStack<>();

        assertEquals(null, stack.peek());
    }

    @Test
    public void testSearchPositive() {
        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(3, stack.search(40));
    }

    @Test
    public void testSearchNegative() {
        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(-1, stack.search(80));
    }

    @Test
    public void testSearchEmpty() {
        PStack<Integer> stack = new PStack<>();

        assertEquals(-1, stack.search(80));
    }


    @Test
    public void testContainsPositive() {
        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(true, stack.contains(40));
    }

    @Test
    public void testContainsNegative() {
        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(false, stack.contains(40));
    }

    @Test
    public void testContainsEmpty() {
        PStack<Integer> stack = new PStack<>();

        assertEquals(false, stack.contains(40));
    }

    @Test
    public void testGetPositive() {

        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(20, (long) stack.get(1));
    }

    @Test
    public void testGetNegative() {

        PStack<Integer> stack = new PStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(null, stack.get(4));
    }

    @Test
    public void testForLargeStack() {

        PStack<String> stack = new PStack<>(5);

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");
        stack.push("word6");
        stack.push("word7");
        stack.push("word8");
        stack.push("word9");
        stack.push("word10");
        stack.push("word11");
        stack.push("word12");
        stack.push("word13");

        assertEquals("word13", stack.peek());
    }

    @Test
    public void testSizeWhenDefaultSmall() {
        PStack<String> stack = new PStack<>();

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");

        assertEquals(5, stack.size());
    }

    @Test
    public void testSizeWhenDefaultLarge() {
        PStack<String> stack = new PStack<>();

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");
        stack.push("word6");
        stack.push("word7");
        stack.push("word8");
        stack.push("word9");
        stack.push("word10");
        stack.push("word11");
        stack.push("word12");
        stack.push("word13");

        assertEquals(13, stack.size());
    }

    @Test
    public void testSizeWhenCustomSmall() {
        PStack<String> stack = new PStack<>(8);

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");

        assertEquals(5, stack.size());
    }

    @Test
    public void testSizeWhenCustomLarge() {
        PStack<String> stack = new PStack<>(10);

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");
        stack.push("word6");
        stack.push("word7");
        stack.push("word8");
        stack.push("word9");
        stack.push("word10");
        stack.push("word11");
        stack.push("word12");
        stack.push("word13");

        assertEquals(13, stack.size());
    }

    @Test
    public void testCapacityWhenDefaultSmall() {
        PStack<String> stack = new PStack<>();

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");

        assertEquals(10, stack.capacity());
    }

    @Test
    public void testCapacityWhenDefaultLarge() {
        PStack<String> stack = new PStack<>();

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");
        stack.push("word6");
        stack.push("word7");
        stack.push("word8");
        stack.push("word9");
        stack.push("word10");
        stack.push("word11");
        stack.push("word12");
        stack.push("word13");

        assertEquals(20, stack.capacity());
    }

    @Test
    public void testCapacityWhenCustomSmall() {
        PStack<String> stack = new PStack<>(8);

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");

        assertEquals(8, stack.capacity());
    }

    @Test
    public void testCapacityWhenCustomLarge() {
        PStack<String> stack = new PStack<>(9);

        stack.push("word1");
        stack.push("word2");
        stack.push("word3");
        stack.push("word4");
        stack.push("word5");
        stack.push("word6");
        stack.push("word7");
        stack.push("word8");
        stack.push("word9");
        stack.push("word10");
        stack.push("word11");
        stack.push("word12");
        stack.push("word13");

        assertEquals(18, stack.capacity());
    }


}