package io.hank.leetcode.practices;

/**
 * <pre>
 * Given a non-negative integer c, decide whether there're two integers a and b such that a^2 + b^2 = c.
 *
 *
 *
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= c <= 2^31 - 1
 * </pre>
 */
public class _633_Sum_of_Square_Numbers extends LeetcodeProblemSolution {
    boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);

        while (left <= right) {
            long powSum = left * left + right * right;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
