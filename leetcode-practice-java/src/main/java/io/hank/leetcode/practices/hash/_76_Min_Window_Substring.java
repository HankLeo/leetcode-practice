package io.hank.leetcode.practices.hash;

import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s 和 t 由英文字母组成
 * </pre>
 */
public class _76_Min_Window_Substring extends LeetcodeProblemSolution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 使用哈希表记录字符的数量，用已满足的字符count检查是否已经全部满足
        // 右指针不断迭代查找满足的子串
        // 每当有新子串刚好满足时，滑动左指针尝试寻找更短的子串
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> have = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        int minLen = s.length() + 1;
        int resLeft = -1, resRight = -1;
        while (right < s.length()) {
            char cur = s.charAt(right);

            if (need.containsKey(cur)) {
                have.put(cur, have.getOrDefault(cur, 0) + 1);
                if (have.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 检查最小长度
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }
                // 开始移动滑动窗口左侧
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    int cnt = have.get(d) - 1;
                    have.put(d, cnt);
                    if (cnt < need.get(d)) {
                        valid--;
                    }
                }
            }

            right++;
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resRight + 1);
    }

    @Override
    public void execute() {
        super.execute();
        String s = "abc", t = "cba";
        System.out.println(minWindow(s, t));
    }

    public static void main(String[] args) {
        new _76_Min_Window_Substring().execute();
    }
}
