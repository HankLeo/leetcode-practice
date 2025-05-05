package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 *
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 *
 * Constraints:
 *
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * </pre>
 */
public class _188_Best_Buy_Sell_Stock_with_K_Times extends LeetcodeProblemSolution {

    @Topic({TopicType.DP, TopicType.GREEDY})
    @TimeComplexity(ComplexityType.O_KN)
    @SpaceComplexity(ComplexityType.O_K)
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {   // 这种情况下该问题退化为普通的股票交易问题
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        // 定义 maxProfit[i][j] 表示在第 j 天结束时，最多进行了 i 次交易所能获得的最大利润
        // 则 maxProfit[i][j] = max(maxProfit[i][j-1], max(prices[j] - prices[m] + maxProfit[i-1][m]))，其中 m 是 0 到 j-1 的任意值
        int[][] maxProfit = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = maxProfit[i - 1][0] - prices[0]; // 记录 maxProfit[i-1][m] - prices[m] 的最大值
            for (int j = 1; j < n; j++) {
                maxProfit[i][j] = Math.max(maxProfit[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, maxProfit[i - 1][j] - prices[j]);
            }
        }
        return maxProfit[k][n - 1];
    }
}
