package com.example.prateek.problemsolving;

import org.junit.Test;

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
    public void testDequeuePositive() {
        PQueue<String> queue = new PQueue<>();

        queue.enqueue("word1");
        queue.enqueue("word2");
        queue.enqueue("word3");
        queue.enqueue("word4");

        assertEquals("word1", queue.dequeue());

        assertEquals("word2", queue.peek());
    }

    @Test
    public void testDequeueNoElement() {
        PQueue<String> queue = new PQueue<>();

        assertEquals(null, queue.dequeue());
    }

    @Test
    public void testDequeueAfterAllDelete() {

        PQueue<String> queue = new PQueue<>();

        queue.enqueue("word1");
        queue.enqueue("word2");

        queue.dequeue();
        queue.dequeue();

        assertEquals(null, queue.dequeue());
        assertEquals(null, queue.peek());
    }

    @Test
    public void testDequeueCustom() {
        PQueue<String> queue = new PQueue<>(5);

        queue.enqueue("word1");
        queue.enqueue("word2");
        queue.enqueue("word3");
        queue.enqueue("word4");

        assertEquals("word1", queue.dequeue());
        assertEquals("word2", queue.dequeue());
        assertEquals("word3", queue.dequeue());

        assertEquals("word4", queue.peek());

        queue.enqueue("word5");
        queue.enqueue("word6");
        queue.enqueue("word7");

        assertEquals("word4", queue.dequeue());
        assertEquals("word5", queue.dequeue());

        assertEquals("word6", queue.peek());

        assertEquals("word6", queue.dequeue());
    }

    @Test
    public void testIsEmptyNotAdded() {
        PQueue<String> queue = new PQueue<>();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmptyAfterAllDeleted() {
        PQueue<String> queue = new PQueue<>();

        queue.enqueue("word1");
        queue.enqueue("word2");

        queue.dequeue();
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmptyFullAndThenDeletedAll() {
        PQueue<String> queue = new PQueue<>(3);

        queue.enqueue("word1");
        queue.enqueue("word2");
        queue.enqueue("word3");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmptyFullThenDeleteSomeThenAddAndDeleteAll() {

        PQueue<String> queue = new PQueue<>(3);

        queue.enqueue("word1");
        queue.enqueue("word2");
        queue.enqueue("word3");

        queue.dequeue();
        queue.dequeue();

        queue.enqueue("word4");
        queue.enqueue("word5");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }
}