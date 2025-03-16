package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 * </pre>
 */
public class _70_Climbing_Stairs extends LeetcodeProblemSolution {

    @Topic({TopicType.DP, TopicType.MATH})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // dp[n] = dp[n -1] + dp[n - 2]
        int n_1 = 2, n_2 = 1;
        for (int i = 2; i < n; i++) {
            int cur = n_1 + n_2;
            n_2 = n_1;
            n_1 = cur;
        }
        return n_1;
    }
}
