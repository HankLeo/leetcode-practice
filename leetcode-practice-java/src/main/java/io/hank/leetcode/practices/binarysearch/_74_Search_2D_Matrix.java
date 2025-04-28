package io.hank.leetcode.practices.binarysearch;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * </pre>
 */
public class _74_Search_2D_Matrix extends LeetcodeProblemSolution {

    @Topic(TopicType.BINARY_SEARCH)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int rLow = 0, rHigh = rows - 1, cLow = 0, cHigh = cols - 1;
        while (rLow <= rHigh) {
            int rMid = rLow + (rHigh - rLow) / 2;
            if (target > matrix[rMid][cols - 1]) {
                // next row
                rLow = rMid + 1;
            } else {
                if (target < matrix[rMid][0]) {
                    // last row
                    rHigh = rMid - 1;
                } else {
                    // current row
                    while (cLow < cHigh) {
                        int cMid = cLow + (cHigh - cLow) / 2;
                        if (target == matrix[rMid][cMid]) {
                            return true;
                        }
                        if (target > matrix[rMid][cMid]) {
                            cLow = cMid + 1;
                        } else {
                            cHigh = cMid - 1;
                        }
                    }
                    return target == matrix[rMid][cLow];
                }
            }
        }
        return false;
    }
}
