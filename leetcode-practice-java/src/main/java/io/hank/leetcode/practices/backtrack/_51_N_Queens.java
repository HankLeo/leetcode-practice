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
        // 一行只出现一个，逐行递归
        // 一列也只出现一个，正对角线、反对角线也只出现一个
        // 标记以上4个状态并回溯
        List<List<String>> res = new ArrayList<>();
        int[] qCols = new int[n]; // 记录每一行的皇后位置
        boolean[] blockedCols = new boolean[n];
        boolean[] blockedDiags1 = new boolean[2 * n - 1]; // 正对角线
        boolean[] blockedDiags2 = new boolean[2 * n - 1]; // 反对角线
        backtrack(n, res, qCols, 0, blockedCols, blockedDiags1, blockedDiags2);
        return res;
    }

    private void backtrack(int n, List<List<String>> res, int[] qCols,
                           int row, boolean[] blockedCols, boolean[] blockedDiags1, boolean[] blockedDiags2) {
        if (row == n) {
            // 满足条件的解
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[qCols[i]] = 'Q';
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            // 迭代每一个col的可能
            int diag1 = n - row + col - 1, diag2 = row + col;
            if (!blockedCols[col] && !blockedDiags1[diag1] && !blockedDiags2[diag2]) {
                blockedCols[col] = true;
                blockedDiags1[diag1] = true;
                blockedDiags2[diag2] = true;
                qCols[row] = col;
                backtrack(n, res, qCols, row + 1, blockedCols, blockedDiags1, blockedDiags2);
                blockedCols[col] = false;
                blockedDiags1[diag1] = false;
                blockedDiags2[diag2] = false;
                qCols[row] = 0;
            }
        }
    }
}
