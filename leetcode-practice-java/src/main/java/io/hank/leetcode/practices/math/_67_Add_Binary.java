package io.hank.leetcode.practices.math;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 *
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 10^4
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * </pre>
 */
public class _67_Add_Binary extends LeetcodeProblemSolution {

    @Topic(TopicType.BIT_MANIPULATION)
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int r = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || r > 0; i--, j--) {
            int sum = r;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            r = sum / 2;
        }
        return ans.reverse().toString();
    }
}
