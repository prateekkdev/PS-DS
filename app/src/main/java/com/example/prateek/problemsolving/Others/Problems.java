package com.example.prateek.problemsolving.Others;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 2/21/18.
 */

public class Problems {

    class Position {
        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    /**
     * n-queen problem
     */
    public List<Position> findNQueen(int n) {

        List<Position> queensList = new LinkedList<>();

        placeQueen(0, n, queensList);

        return queensList;
    }

    private boolean placeQueen(int col, int n, List<Position> queensList) {

        if (col >= n) {
            return true;
        }

        for (int row = 0; row < n; row++) {

            Position current = new Position(row, col);

            boolean isSafe = isQueenSafe(current, queensList);

            if (!isSafe) {
                continue;
            }

            queensList.add(current);

            isSafe = placeQueen(col + 1, n, queensList);

            if (isSafe) {
                return true;
            } else {
                queensList.remove(current);
            }
        }

        return false;
    }

    private boolean isQueenSafe(Position current, List<Position> queensList) {

        for (Position position : queensList) {
            if ((Math.abs(current.row - position.row) == Math.abs(current.col - position.col))
                    || current.row == position.row) {
                return false;
            }
        }
        return true;
    }
}