package io.hank.leetcode.practices.backtrack;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * </pre>
 */
public class _51_N_Queens extends LeetcodeProblemSolution {

    @Topic(TopicType.BACKTRACK)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        int[] queenPos = new int[n];
        backtrack(n, result, 0, queenPos, cols, diag1, diag2);
        return result;
    }

    private void backtrack(int n, List<List<String>> result, int row, int[] queenPos, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (n == row) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[queenPos[i]] = 'Q';
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagId1 = row + col;
            int diagId2 = row - col + n - 1;
            if (!cols[col] && !diag1[diagId1] && !diag2[diagId2]) {
                queenPos[row] = col;
                cols[col] = true;
                diag1[diagId1] = true;
                diag2[diagId2] = true;

                backtrack(n, result, row + 1, queenPos, cols, diag1, diag2);
                queenPos[row] = 0;
                cols[col] = false;
                diag1[diagId1] = false;
                diag2[diagId2] = false;
            }
        }
    }
}
