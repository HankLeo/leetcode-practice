package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 *
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值。
 *
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 *
 *
 * 示例 1:
 *
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 *
 * 示例 2:
 *
 * 输入: n = 1
 * 输出: 1
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 * </pre>
 */
public class _790_Domino_and_Tromino_Tiling extends LeetcodeProblemSolution {
    private static final int MOD = 1000000007;

    @Topic(TopicType.DP)
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        // dp[i]表示铺满i列
        // a[i]表示缺第i列的上角
        // b[i]表示缺第i列的下角
        // 由于对称性，a[i] = b[i]
        // a[i] = dp[i - 2]（铺满i-2再加1个L）+ b[i - 1]（缺下角的i-1下方补一个横的）
        // dp[i] = dp[i - 1]（补一个竖的）+ dp[i - 2]（补2个横的）+ a[i - 1] + b[i - 1]（补L）
        long[] dp = new long[n + 1];
        // dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        long[] a = new long[n + 1];
        a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = (dp[i - 2] + a[i - 1]) % MOD;
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * a[i - 1]) % MOD;
        }
        return (int) dp[n];
    }
}
