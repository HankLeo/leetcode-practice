package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;

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

    @Topic(TopicType.HASH)
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        for (int right = 0; right < s.length(); right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
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
