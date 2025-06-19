package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.TimeComplexity;
import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 * </pre>
 */
public class _290_Word_Pattern extends LeetcodeProblemSolution {

    @Topic(TopicType.HASH)
    @TimeComplexity(ComplexityType.O_N)
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }

        // put key return null if nx or last value if ex
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < arr.length; i++) {
            // int值在[-128,127]范围内是使用缓存中的对象，超过这个范围就创建新的Integer对象，所以需要直接使用Integer防止put时自动装箱
            if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) {
                return false;
            }
        }
        return true;
    }
}
