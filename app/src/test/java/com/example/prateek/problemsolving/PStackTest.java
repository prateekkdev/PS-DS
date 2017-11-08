package com.example.prateek.problemsolving;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

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
}