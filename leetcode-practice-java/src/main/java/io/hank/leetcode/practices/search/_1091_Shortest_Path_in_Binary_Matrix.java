package io.hank.leetcode.practices.search;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 * </pre>
 */
public class _1091_Shortest_Path_in_Binary_Matrix extends LeetcodeProblemSolution {

    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1},
            {1, 0}, {1, 1}, {1, -1},
            {-1, 0}, {-1, 1}, {-1, -1}
    };

    @Topic({TopicType.BFS, TopicType.MATRIX})
    @TimeComplexity(ComplexityType.O_N2)
    @SpaceComplexity(ComplexityType.O_N2)
    int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }

        // BFS, store the [i, j] of element in queue
        // set value of grid[i, j] as path length to store path length
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            int pathLen = grid[row][col];

            if (row == len - 1 && col == len - 1) {
                return pathLen;
            }

            // search all the directions of each element, BFS
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (nextRow >= 0 && nextRow < len && nextCol >= 0 && nextCol < len && grid[nextRow][nextCol] == 0) {
                    // 0 means not been searched, add as new searched element and path + 1
                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = pathLen + 1;
                }
            }
        }
        return -1;
    }
}
