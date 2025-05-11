package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Stack;

/**
 * <pre>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 10^4
 * s[i] 为 '(' 或 ')'
 * </pre>
 */
public class _32_Longest_Valid_Parentheses extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // dp[i] -> 包含i在内的有效子串的长度
        // i = '(' -> dp[i] = 0
        // i = ')' && i - 1 = '(' -> dp[i] = 2 + dp[i - 2]
        // i = ')' && i - 1 = ')' -> 判断是否存在i - dp[i - 1] - 1 = '('
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? 2 + dp[i - 2] : 2;
                } else {
                    int prev = dp[i - 1];
                    int target = i - prev - 1;
                    if (target >= 0 && s.charAt(target) == '(') {
                        dp[i] = 2 + prev;
                        if (target > 0) {
                            dp[i] += dp[target - 1]; // 加上之前的合法长度
                        }
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Topic(TopicType.STACK)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int longestValidParentheses2(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.isEmpty()) {
                    stk.push(i);
                } else {
                    // 栈非空
                    max = Math.max(max, i - stk.peek());
                }
            }
        }
        return max;
    }
}
