package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 *
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * </pre>
 */
public class _766_Toeplitz_Matrix extends LeetcodeProblemSolution {

    @Topic(TopicType.MATRIX)
    public boolean isToeplitzMatrix(int[][] matrix) {
        // first row
        for (int i = 0; i < matrix[0].length - 1; i++) {
            int val = matrix[0][i];
            int row = 1, col = i + 1;
            while (row < matrix.length && col < matrix[0].length) {
                if (val != matrix[row][col]) {
                    return false;
                }
                row++;
                col++;
            }
        }
        // first column
        for (int j = 1; j < matrix.length - 1; j++) {
            int val = matrix[j][0];
            int row = j + 1;
            int col = 1;
            while (row < matrix.length && col < matrix[0].length) {
                if (val != matrix[row][col]) {
                    return false;
                }
                row++;
                col++;
            }
        }
        return true;
    }
}
