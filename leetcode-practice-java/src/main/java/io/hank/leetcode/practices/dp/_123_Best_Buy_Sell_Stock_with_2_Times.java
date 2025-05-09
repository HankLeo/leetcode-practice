package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 * </pre>
 */
public class _123_Best_Buy_Sell_Stock_with_2_Times extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE; // 第一次买入后的最大利润
        int sell1 = 0; // 第一次卖出后的最大利润
        int buy2 = Integer.MIN_VALUE; // 第二次买入后的最大利润
        int sell2 = 0; // 第二次卖出后的最大利润
        for (int price : prices) {
            buy1 = Math.max(buy1, -price); // 第i天买入或者不买入
            sell1 = Math.max(sell1, buy1 + price); // 第i天卖出或者不卖出
            buy2 = Math.max(buy2, sell1 - price); // 第i天买入或者不买入
            sell2 = Math.max(sell2, buy2 + price); // 第i天卖出或者不卖出
        }
        return sell2;
    }
}
