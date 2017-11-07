package com.example.prateek.problemsolving;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by prateek on 6/11/17.
 */
public class PLinkedListTest {

    @Test
    public void add() throws Exception {


    }

    @Test
    public void addFirst() throws Exception {

        PLinkedList list = new PLinkedList();

        list.add(10);


        assertThat(list.size(), is(1));

        list.remove();

        assertThat(list.size(), is(0));
    }

    @Test
    public void addLast() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void removeFirst() throws Exception {
    }

    @Test
    public void remove1() throws Exception {
    }

    @Test
    public void removeLast() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

}