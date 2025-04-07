package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 * Example 1:
 *
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 *
 * Explanation:
 *
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 *
 * Output: "leotcede"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 10^5
 * s consist of printable ASCII characters.
 * </pre>
 */
public class _345_Reverse_Vowels_of_String extends LeetcodeProblemSolution {

    @Topic(TopicType.TWO_POINTER)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!vowels.contains(leftChar)) {
                result[left++] = leftChar;
            } else if (!vowels.contains(rightChar)) {
                result[right--] = rightChar;
            } else {
                result[left++] = rightChar;
                result[right--] = leftChar;
            }
        }
        return new String(result);
    }
}
