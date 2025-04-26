package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * </pre>
 */
public class _438_Find_All_Anagrams_In_String extends LeetcodeProblemSolution {

    @Topic({TopicType.HASH, TopicType.STRING})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return res;
        }
        int[] sCharSeq = new int[26];
        int[] pCharSeq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCharSeq[s.charAt(i) - 'a']++;
            pCharSeq[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCharSeq, pCharSeq)) {
            res.add(0);
        }

        for (int i = 0; i + pLen < sLen; i++) {
            sCharSeq[s.charAt(i) - 'a']--;
            sCharSeq[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCharSeq, pCharSeq)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
