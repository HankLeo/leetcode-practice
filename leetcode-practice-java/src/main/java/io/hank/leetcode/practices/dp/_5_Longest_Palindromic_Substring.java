package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * </pre>
 */
public class _5_Longest_Palindromic_Substring extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public String longestPalindrome1(String s) {
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


    @Topic(TopicType.TWO_POINTER)
    public String longestPalindrome(String s) {
        // 双指针中心扩散，中心可能为一个点（奇数），也可能为两个（偶数）
        int maxLen = 0, maxStart = 0, maxEnd = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int[] oddRange = palindromeLen(s, i, i);
            int[] evenRange = palindromeLen(s, i, i + 1);
            int oddLen = oddRange[1] - oddRange[0] + 1;
            int evenLen = evenRange[1] - evenRange[0] + 1;
            if (oddLen >= evenLen && oddLen > maxLen) {
                maxStart = oddRange[0];
                maxEnd = oddRange[1];
                maxLen = oddLen;
            }
            if (evenLen > oddLen && evenLen > maxLen) {
                maxStart = evenRange[0];
                maxEnd = evenRange[1];
                maxLen = oddLen;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private int[] palindromeLen(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - 1};
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
