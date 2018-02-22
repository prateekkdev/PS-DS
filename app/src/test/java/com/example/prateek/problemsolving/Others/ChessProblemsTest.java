package com.example.prateek.problemsolving.Others;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by admin on 2/21/18.
 */

public class ChessProblemsTest {

    private ChessProblems chessProblems;

    @Before
    public void init() {
        chessProblems = new ChessProblems();
    }

    @Test
    public void testFindNQueen() {

        List<ChessProblems.Position> list1 = chessProblems.findNQueen(3);
        assertEquals(0, list1.size());

        List<ChessProblems.Position> list2 = chessProblems.findNQueen(4);
        assertEquals(4, list2.size());

        List<ChessProblems.Position> list3 = chessProblems.findNQueen(5);
        assertEquals(5, list3.size());
    }

    @Test
    public void testCheckIfInputValidLowerRow() {
        boolean check = chessProblems.checkIfInputIsValid(new ChessProblems.Position(-1, 3), new ChessProblems.Position(2, 2));
        assertEquals(false, check);
    }

    @Test
    public void testCheckIfInputValidHigherRow() {
        boolean check = chessProblems.checkIfInputIsValid(new ChessProblems.Position(11, 0), new ChessProblems.Position(2, 2));
        assertEquals(false, check);
    }

    @Test
    public void testCheckIfInputValidLowerCol() {
        boolean check = chessProblems.checkIfInputIsValid(new ChessProblems.Position(0, -3), new ChessProblems.Position(2, 2));
        assertEquals(false, check);
    }

    @Test
    public void testCheckIfInputValidHigherCol() {
        boolean check = chessProblems.checkIfInputIsValid(new ChessProblems.Position(0, 11), new ChessProblems.Position(2, 2));
        assertEquals(false, check);
    }

    @Test
    public void testCheckIfInputValideNormal() {
        boolean check = chessProblems.checkIfInputIsValid(new ChessProblems.Position(0, 3), new ChessProblems.Position(2, 2));
        assertEquals(true, check);
    }


    @Test
    public void testIsKingThreatenedByQueenTrueDiagonal() {
        boolean check = chessProblems.isKingThreatenedByQueenInChessBoard(new ChessProblems.Position(0, 3), new ChessProblems.Position(1, 2));
        assertEquals(true, check);
    }

    @Test
    public void testIsKingThreatenedByQueenTrueSameRow() {
        boolean check = chessProblems.isKingThreatenedByQueenInChessBoard(new ChessProblems.Position(1, 0), new ChessProblems.Position(1, 2));
        assertEquals(true, check);
    }

    @Test
    public void testIsKingThreatenedByQueenTrueSameCol() {
        boolean check = chessProblems.isKingThreatenedByQueenInChessBoard(new ChessProblems.Position(3, 2), new ChessProblems.Position(1, 2));
        assertEquals(true, check);
    }

    @Test
    public void testIsKingThreatenedByQueenFalseSafe() {
        boolean check = chessProblems.isKingThreatenedByQueenInChessBoard(new ChessProblems.Position(0, 0), new ChessProblems.Position(1, 2));
        assertEquals(false, check);
    }
}