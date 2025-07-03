package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * </pre>
 */
public class _28_Find_Index_of_First_Occurrence_in_String extends LeetcodeProblemSolution {

    @Topic(TopicType.TWO_POINTER)
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            int p = i, q = 0; // p表示haystack当前字符位置，q表示needle当前匹配位置
            while (q < n) {
                if (haystack.charAt(p) == needle.charAt(q)) {
                    p++;
                    q++;
                } else {
                    break;
                }
            }
            if (q == n) {
                return i;
            }
        }
        return -1;
    }
}
