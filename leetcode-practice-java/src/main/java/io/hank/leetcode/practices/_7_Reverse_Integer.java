package io.hank.leetcode.practices;

/**
 * <pre>
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 *   Input: x = 123
 *   Output: 321
 *
 * Example 2:
 *   Input: x = -123
 *   Output: -321
 *
 * Example 3:
 *   Input: x = 120
 *   Output: 21
 *
 * Constraints:
 *   -2^31 <= x <= 2^31 - 1
 * </pre>
 */
public class _7_Reverse_Integer extends LeetcodeProblemSolution {
    int reverse(int x) {
        if (x == 0) {
            return x;
        }

        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }

        int result = 0;

        while (x != 0) {
            int mod = x % 10;
            x /= 10;
            if (result > (Integer.MAX_VALUE - mod) / 10) {
                return 0;
            }
            result = 10 * result + mod;
        }

        return negative ? -result : result;
    }
}
