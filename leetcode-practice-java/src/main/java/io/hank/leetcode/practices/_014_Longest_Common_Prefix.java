package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

/**
 * <pre>
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * </pre>
 */
public class _014_Longest_Common_Prefix extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_1)
    String longestCommonPrefix(String[] v) {
        if (v == null || v.length == 0) {
            return "";
        }

        String prefix = v[0];
        for (int i = 1; i < v.length - 1; i++) {
            while (!v[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

}
