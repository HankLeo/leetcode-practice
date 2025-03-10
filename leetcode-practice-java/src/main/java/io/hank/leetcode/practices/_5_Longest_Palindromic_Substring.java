package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.SpaceComplexity;
import io.hank.leetcode.annotations.TimeComplexity;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * <p>
 * Output: "bb"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * <p>
 * s consist of only digits and English letters.
 */
public class _5_Longest_Palindromic_Substring extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 1;
        int maxCenter = 0;

        // make string length to be odd number
        // s consist of only digits and English letters, so can use '#'
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        String processed = sb.toString();

        int n = processed.length();
        int[] dp = new int[n];
        int center = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            // use mirror of palindrome to save time
            if (i < right) {
                dp[i] = Math.min(dp[2 * center - i], right - i);
            }

            while (i > dp[i] && i + dp[i] < n - 1 && processed.charAt(i - dp[i] - 1) == processed.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            // move the center and right if necessary
            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxCenter = i;
            }
        }

        int realStart = (maxCenter - maxLength) / 2;
        return s.substring(realStart, realStart + maxLength);
    }

    @Override
    public void execute() {
        super.execute();

        // Example 1
        String s = "ss";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + longestPalindrome(s));

        // Example 2
        s = "babad";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + longestPalindrome(s));
    }
}
