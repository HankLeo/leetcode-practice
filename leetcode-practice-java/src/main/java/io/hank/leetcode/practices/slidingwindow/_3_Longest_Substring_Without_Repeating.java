package io.hank.leetcode.practices.slidingwindow;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * <p>
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * <p>
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _3_Longest_Substring_Without_Repeating extends LeetcodeProblemSolution {

    @Topic({TopicType.HASH, TopicType.SLIDING_WINDOW})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] charCnt = new int[128];
        int left = 0, right = 1;
        charCnt[s.charAt(left)] = 1;
        int ans = 1;
        while (right < s.length()) {
            char rChar = s.charAt(right);
            charCnt[rChar] += 1;
            while (charCnt[rChar] > 1) {
                charCnt[s.charAt(left)] -= 1;
                left++;
            }
            int curLen = right - left + 1;
            ans = Math.max(ans, curLen);
            right++;
        }
        return ans;
    }

    @Override
    public void execute() {
        super.execute();

        // Example 1
        String input1 = "abcabcbb";
        System.out.println("Input: s = " + input1);
        System.out.println("Output: " + lengthOfLongestSubstring(input1));

        // Example 2
        String input2 = "bbbbb";
        System.out.println("Input: s = " + input2);
        System.out.println("Output: " + lengthOfLongestSubstring(input2));

        // Example 3
        String input3 = "pwwkew";
        System.out.println("Input: s = " + input3);
        System.out.println("Output: " + lengthOfLongestSubstring(input3));
    }
}
