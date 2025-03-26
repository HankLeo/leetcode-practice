package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.Arrays;

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
        if (prices.length <= 1) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxProfitNormal(prices);
        } else {
            return maxProfitWithK(k, prices);
        }
    }

    private int maxProfitNormal(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    private int maxProfitWithK(int k, int[] prices) {
        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        for (int price : prices) {
            int[] preBuys = Arrays.copyOf(buys, k);
            int[] preSells = Arrays.copyOf(sells, k);
            buys[0] = Math.max(preBuys[0], -price);
            sells[0] = Math.max(preSells[0], preBuys[0] + price);
            // status change
            for (int i = 1; i < k; i++) {
                buys[i] = Math.max(preBuys[i], preSells[i - 1] - price);
                sells[i] = Math.max(preSells[i], preBuys[i] + price);
            }
        }
        int max = 0;
        for (int sell : sells) {
            max = Math.max(max, sell);
        }
        return max;
    }
}
