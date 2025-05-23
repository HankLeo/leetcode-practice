package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 *
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4
 * Output: [[1,2],[3,4]]
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * </pre>
 */
public class _566_Reshape_the_Matrix extends LeetcodeProblemSolution {

    @Topic(TopicType.ARRAY)
    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_MN)
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (rows * cols != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int index = 0;
        for (int[] ints : mat) {
            for (int col = 0; col < cols; col++) {
                res[index / c][index % c] = ints[col];
                index++;
            }
        }
        return res;
    }
}
