package io.hank.leetcode.kotlin.practices

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 *
 * Output: 3
 *
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 *
 * Output: 1
 *
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 *
 * Output: 3
 *
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class _003_Longest_Substring_Without_Repeating : LeetcodeProblemSolution() {
    private fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val charIndex = IntArray(size = 128).apply {
            fill(-1)
        }
        var left = 0

        s.forEachIndexed { right, char ->
            charIndex[char.code].takeIf { it >= left }?.let { left = it + 1 }
            charIndex[char.code] = right
            maxLength = maxLength.coerceAtLeast(right - left + 1)
        }

        return maxLength
    }

    override fun execute() {
        super.execute()

        // Example 1
        val input1 = "abcabcbb"
        println("Input: s = $input1")
        println("Output: ${lengthOfLongestSubstring(input1)}")

        // Example 2
        val input2 = "bbbbb"
        println("Input: s = $input2")
        println("Output: ${lengthOfLongestSubstring(input2)}")

        // Example 3
        val input3 = "pwwkew"
        println("Input: s = $input3")
        println("Output: ${lengthOfLongestSubstring(input3)}")
    }
}