package io.hank.leetcode.practices;

import java.util.List;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

/**
 * <pre>
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * Example 2:
 *
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 * </pre>
 */
public class _524_Longest_Word_in_Dictionary_through_Deleting extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_1)
    String findLongestWord(String str, List<String> dictionary) {
        String result = "";
        for (String target : dictionary) {
            int resultLen = result.length(), targetLen = target.length();
            if (targetLen < resultLen || (targetLen == resultLen && target.compareTo(result) > 0)) {
                continue;
            }
            // int strP = 0, targetP = 0;
            // while (strP < str.length() && targetP < targetLen) {
            //     if (str.charAt(strP) == target.charAt(targetP)) {
            //         targetP++;
            //     }
            //     strP++;
            // }
            // if (targetP == targetLen) {
            //     result = target;
            // }
            int pos = -1;
            for (int i = 0; i < targetLen; i++) {
                pos = str.indexOf(target.charAt(i), pos + 1);
                if (pos == -1) {
                    break;
                }
            }
            if (pos != -1) {
                result = target;
            }
        }
        return result;
    }

}
