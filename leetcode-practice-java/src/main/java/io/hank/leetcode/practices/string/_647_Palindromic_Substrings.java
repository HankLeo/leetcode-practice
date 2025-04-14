package io.hank.leetcode.practices.string;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * </pre>
 */
public class _647_Palindromic_Substrings extends LeetcodeProblemSolution {

    @Override
    public void execute() {
        super.execute();
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
    }

    @Topic({TopicType.STRING, TopicType.TWO_POINTER})
    @TimeComplexity(ComplexityType.O_N2)
    @SpaceComplexity(ComplexityType.O_1)
    public int countSubstrings(String s) {
        // 中心遍历，双向扩展
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i); // 奇数
            count += expand(s, i, i + 1); // 偶数
        }
        return count;
    }

    private int expand(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            count++;
        }
        return count;
    }
}
