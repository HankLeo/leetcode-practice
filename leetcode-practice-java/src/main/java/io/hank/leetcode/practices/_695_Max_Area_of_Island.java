package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 * 0,0,1,0,0,0,0,1,0,0,0,0,0
 * 0,0,0,0,0,0,0,1,1,1,0,0,0
 * 0,1,1,0,1,0,0,0,0,0,0,0,0
 * 0,1,0,0,1,1,0,0,1,0,1,0,0
 * 0,1,0,0,1,1,0,0,1,1,1,0,0
 * 0,0,0,0,0,0,0,0,0,0,1,0,0
 * 0,0,0,0,0,0,0,1,1,1,0,0,0
 * 0,0,0,0,0,0,0,1,1,0,0,0,0
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * </pre>
 */
public class _695_Max_Area_of_Island extends LeetcodeProblemSolution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Topic({TopicType.DFS, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_MN)
    int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        for (int[] direction : DIRECTIONS) {
            area += dfs(grid, i + direction[0], j + direction[1]);
        }
        return area;
    }
}
