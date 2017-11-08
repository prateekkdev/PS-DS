package com.example.prateek.problemsolving;

import org.junit.Test;

import java.util.Queue;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by prateek on 7/11/17.
 */

public class PQueueTest {

    @Test
    public void testEnqueuePositive() {

        PQueue<String> queue = new PQueue<>();

        queue.enqueue("word1");
        queue.enqueue("word2");
        queue.enqueue("word3");
        queue.enqueue("word4");

        assertThat("word1", is(queue.peek()));
    }

    @Test
    public void testEnqueueNegative() {

        PQueue<String> queue = new PQueue<>();

        assertThat(null, is(queue.peek()));
    }

    @Test
    public void testIsEmpty() {
        PQueue<String> queue = new PQueue<>();
        assertEquals(true, queue.isEmpty());
    }
}