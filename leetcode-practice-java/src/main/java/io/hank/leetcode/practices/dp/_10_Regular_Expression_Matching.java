package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *   Input: s = "aa", p = "a"
 *   Output: false
 *   Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *   Input: s = "aa", p = "a*"
 *   Output: true
 *   Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 *   Input: s = "ab", p = ".*"
 *   Output: true
 *   Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Constraints:
 *   1 <= s.length <= 20
 *   1 <= p.length <= 20
 *   s contains only lowercase English letters.
 *   p contains only lowercase English letters, '.', and '*'.
 *   It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 * </pre>
 */
public class _10_Regular_Expression_Matching extends LeetcodeProblemSolution {

    @Topic({TopicType.DP, TopicType.RECURSION})
    boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // match * pattern for empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // match 0 time or multiple times
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    // one more character matches one more pattern char
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }

        return dp[m][n];
    }
}
