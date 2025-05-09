package io.hank.leetcode.practices.string;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 *
 * Example 1:
 *
 * Input: s = "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 *
 * Example 2:
 *
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '0' or '1'.
 * </pre>
 */
public class _696_Count_Binary_Substrings extends LeetcodeProblemSolution {

    @Topic(TopicType.STRING)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 0, count = 0;
        for (int i = 0; i < s.length(); preLen = curLen, curLen = 0) {
            char c = s.charAt(i);
            while (i < s.length() && s.charAt(i) == c) {
                curLen++;
                i++;
            }
            count += Math.min(preLen, curLen);
        }
        return count;
    }
}
