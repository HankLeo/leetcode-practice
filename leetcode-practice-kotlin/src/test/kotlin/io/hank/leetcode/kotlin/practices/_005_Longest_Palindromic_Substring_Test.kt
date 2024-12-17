package io.hank.leetcode.kotlin.practices

import kotlin.test.Test
import kotlin.test.assertEquals

class _005_Longest_Palindromic_Substring_Test {

    private val solution = _005_Longest_Palindromic_Substring()

    @Test
    fun `test with basic palindrome`() {
        val result = solution.longestPalindrome("babad")
        // The longest palindrome could be either "bab" or "aba"
        assertEquals(true, result == "bab" || result == "aba")
    }

    @Test
    fun `test with single character string`() {
        val result = solution.longestPalindrome("a")
        assertEquals("a", result)
    }

    @Test
    fun `test with entire string as palindrome`() {
        val result = solution.longestPalindrome("racecar")
        assertEquals("racecar", result)
    }

    @Test
    fun `test with string of length 2`() {
        val result = solution.longestPalindrome("aa")
        assertEquals("aa", result)
    }

    @Test
    fun `test with no palindrome longer than 1`() {
        val result = solution.longestPalindrome("abc")
        // Each character is a palindrome by itself
        assertEquals(true, result in listOf("a", "b", "c"))
    }

    @Test
    fun `test with even length palindrome`() {
        val result = solution.longestPalindrome("cbbd")
        assertEquals("bb", result)
    }

    @Test
    fun `test with empty string`() {
        val result = solution.longestPalindrome("")
        assertEquals("", result)
    }
}
