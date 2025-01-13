package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

/**
 * <pre>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *   Input: x = 121
 *   Output: true
 *   Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *   Input: x = -121
 *   Output: false
 *   Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *   Input: x = 10
 *   Output: false
 *   Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *   -2^31 <= x <= 2^31 - 1
 * </pre>
 */
public class _009_Palindrome_Number extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverseValue = 0;
        while (x > reverseValue) {
            reverseValue = 10 * reverseValue + x % 10;
            x /= 10;
        }

        return x == reverseValue || x == reverseValue / 10;
    }
}
