package io.hank.leetcode.practices.math;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 *
 * 示例 1：
 *
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 *
 * 示例 2：
 *
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 * </pre>
 */
public class _1318_Min_Flips_A_or_B_Equals_C extends LeetcodeProblemSolution {

    @Topic(TopicType.BIT_MANIPULATION)
    public int minFlips(int a, int b, int c) {
        // if c_bit == 0, a_bit should be 0 & b_bit should be 0
        // if c_bit == 1, a_bit or b_bit should be 1
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            // int 32bits
            int a_bit = a >> i & 1;
            int b_bit = b >> i & 1;
            int c_bit = c >> i & 1;
            if (c_bit == 0) {
                cnt += a_bit + b_bit;
            } else {
                cnt += a_bit + b_bit == 0 ? 1 : 0;
            }
        }
        return cnt;
    }
}
