package io.hank.leetcode.kotlin.practices

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 *
 * Output: "bab"
 *
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 *
 * Output: "bb"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 *
 * s consist of only digits and English letters.
 */
class _005_Longest_Palindromic_Substring {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) {
            return s
        }

        val processed: String = StringBuilder().also {
            it.append("#")
            s.forEach { c ->
                it.append(c).append("#")
            }
        }.toString()
        val n = processed.length
        var maxLength = 1
        var maxCenter = 0
        var center = 0
        var right = 0
        val dp = IntArray(n)

        for (i in 0..<n) {
            // Manacher's Algorithm
            if (i < right) {
                dp[i] = dp[2 * center - i].coerceAtMost(right - i)
            }

            while (dp[i] < i && i + dp[i] < n - 1 && processed[i - dp[i] - 1] == processed[i + dp[i] + 1]) {
                dp[i]++
            }

            // move center and right
            (center + dp[i]).takeIf { it > right }?.let {
                center = i
                right = it
            }

            dp[i].takeIf { it > maxLength }?.let {
                maxLength = it
                maxCenter = i
            }
        }

        return ((maxCenter - maxLength) / 2).run {
            s.substring(this, this + maxLength)
        }
    }
}
