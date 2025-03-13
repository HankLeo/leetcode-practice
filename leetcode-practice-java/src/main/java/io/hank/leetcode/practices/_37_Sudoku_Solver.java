package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <pre>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 *
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * </pre>
 */
public class _37_Sudoku_Solver extends LeetcodeProblemSolution {
    static final class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    @Topic(TopicType.BACKTRACK)
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        List<Cell> emptyCells = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    emptyCells.add(new Cell(i, j));
                } else {
                    int boxId = (i / 3) * 3 + j / 3;
                    int num = c - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxId][num] = true;
                }
            }
        }
        backtrack(board, rows, cols, boxes, emptyCells);
    }

    private boolean backtrack(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes, List<Cell> emptyCells) {
        if (emptyCells.isEmpty()) {
            return true;
        }

        Cell bestCandidate = findBestCandidate(rows, cols, boxes, emptyCells);
        if (bestCandidate == null) {
            return false;
        }
        int i = bestCandidate.row, j = bestCandidate.col;
        int boxId = (i / 3) * 3 + j / 3;
        List<Integer> candidateValues = getCandidateValues(i, j, rows, cols, boxes);
        if (candidateValues == null) {
            return false;
        }
        for (int num : candidateValues) {
            board[i][j] = (char) (num + '0');
            rows[i][num] = true;
            cols[j][num] = true;
            boxes[boxId][num] = true;
            for (Cell c : emptyCells) {
                if (c.row == i && c.col == j) {
                    emptyCells.remove(c);
                }
            }

            if (backtrack(board, rows, cols, boxes, emptyCells)) {
                return true;
            }

            board[i][j] = '.';
            rows[i][num] = false;
            cols[j][num] = false;
            boxes[boxId][num] = false;
            emptyCells.add(bestCandidate);
        }
        return false;
    }

    private Cell findBestCandidate(boolean[][] rows, boolean[][] cols, boolean[][] boxes, List<Cell> emptyCells) {
        int minCandidateCount = 10;
        Cell bestCandidate = null;
        for (Cell c : emptyCells) {
            int i = c.row, j = c.col;
            int boxId = (i / 3) * 3 + j / 3;
            int count = 0;
            for (int num = 1; num <= 9; num++) {
                if (!rows[i][num] && !cols[j][num] && !boxes[boxId][num]) {
                    count++;
                }
            }
            if (count == 0) {
                return null;
            }
            if (count < minCandidateCount) {
                minCandidateCount = count;
                bestCandidate = c;
                if (count == 1) {
                    break;
                }
            }
        }
        return bestCandidate;
    }

    private List<Integer> getCandidateValues(int i, int j, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        List<Integer> candidateValues = new ArrayList<>();
        int boxId = (i / 3) * 3 + j / 3;
        for (int num  = 1; num <= 9; num++) {
            if (!rows[i][num] && !cols[j][num] && !boxes[boxId][num]) {
                candidateValues.add(num);
            }
        }
        return candidateValues;
    }
}
