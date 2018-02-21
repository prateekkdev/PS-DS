package com.example.prateek.problemsolving.Others;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by admin on 2/21/18.
 */

public class ProblemsTest {

    Problems problems;

    @Before
    public void init() {
        problems = new Problems();
    }

    @Test
    public void testFindNQueen() {

        List<Problems.Position> list1 = problems.findNQueen(3);
        assertEquals(0, list1.size());

        List<Problems.Position> list2 = problems.findNQueen(4);
        assertEquals(4, list2.size());

        List<Problems.Position> list3 = problems.findNQueen(5);
        assertEquals(5, list3.size());
    }
}
