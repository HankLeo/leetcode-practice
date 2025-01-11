package io.hank.leetcode.practices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

public class _345_Reverse_Vowels_of_String extends LeetcodeProblemSolution {
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
