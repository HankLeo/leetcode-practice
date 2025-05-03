package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * </pre>
 */
public class _54_Spiral_Matrix extends LeetcodeProblemSolution {

    @Topic({TopicType.ARRAY, TopicType.MATRIX})
    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_MN)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int total = rows * cols, cnt = 0;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        while (cnt < total) {
            // top行
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                cnt++;
            }
            top++;
            if (cnt == total) {
                break;
            }
            // right列
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
                cnt++;
            }
            right--;
            if (cnt == total) {
                break;
            }
            // bottom行
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
                cnt++;
            }
            bottom--;
            if (cnt == total) {
                break;
            }
            // left列
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                cnt++;
            }
            left++;
            if (cnt == total) {
                break;
            }
        }
        return res;
    }
}
