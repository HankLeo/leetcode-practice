package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * </pre>
 */
public class _200_Number_of_Islands extends LeetcodeProblemSolution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows =0, cols = 0;

    @Topic({TopicType.DFS, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_MN)
    int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '0') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d: dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
