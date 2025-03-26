package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
 *
 * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * </pre>
 */
public class _650_2_Keys_Keyboard extends LeetcodeProblemSolution {

    @Topic(TopicType.MATH)
    @TimeComplexity(ComplexityType.O_SqrtN)
    @SpaceComplexity(ComplexityType.O_1)
    public int minSteps(int n) {
        // m个字符到m * k个字符需要k次操作
        // 乘积由质因数得来，因数之和最小
        if (n == 1) {
            return 0;
        }
        int min = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                min += i;
                n /= i;
            }
        }
        if (n > 1) {
            min += n;
        }
        return min;
    }
}
