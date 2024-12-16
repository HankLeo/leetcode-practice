package io.hank.leetcode.practices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _005_Longest_Palindromic_Substring_Test {
    @Test
    void testLongestPalindrome_NormalCase() {
        _005_Longest_Palindromic_Substring solution = new _005_Longest_Palindromic_Substring();
        String input = "babad";
        String result = solution.longestPalindrome(input);
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    void testLongestPalindrome_NoPalindromeSubstring() {
        _005_Longest_Palindromic_Substring solution = new _005_Longest_Palindromic_Substring();
        String input = "abcde";
        String result = solution.longestPalindrome(input);
        // Any single character is a valid palindrome
        assertTrue(result.equals("a") || result.equals("b") || result.equals("c") || result.equals("d") || result.equals("e"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaa", "bb", ""})
    void testLongestPalindrome_EqualsSelf(String arg) {
        _005_Longest_Palindromic_Substring solution = new _005_Longest_Palindromic_Substring();
        String result = solution.longestPalindrome(arg);
        assertEquals(arg, result);
    }

    @Test
    void testLongestPalindrome_LongString() {
        _005_Longest_Palindromic_Substring solution = new _005_Longest_Palindromic_Substring();
        String input = "abcbaabcd";
        String result = solution.longestPalindrome(input);
        assertEquals("cbaabc", result);
    }
}