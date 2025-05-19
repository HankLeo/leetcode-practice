package io.hank.leetcode.practices.string;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 * </pre>
 */
public class _1456_Max_Num_of_Vowels_in_Sliding_Window extends LeetcodeProblemSolution {

    @Topic({TopicType.STRING, TopicType.SLIDING_WINDOW})
    public int maxVowels(String s, int k) {
        int count = 0;

        // 初始化滑动窗口
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        // 开始滑动
        int maxCount = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            if (isVowel(s.charAt(i))) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u';
    }
}
