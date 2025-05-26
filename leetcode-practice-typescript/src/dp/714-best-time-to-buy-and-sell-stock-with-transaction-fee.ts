function maxProfit(prices: number[], fee: number): number {
    // 第i天卖了 dpHas[i - 1] + prices[i] - fee
    // 第i天没卖 dp[i - 1]
    // dpHas[i] = max(dp[i - 1] - prices[i], dpHas[i - 1])
    const n = prices.length;
    if (n === 1) {
        return 0;
    }
    const dpHas: number[] = new Array(n);
    dpHas[0] = -prices[0];
    const dp: number[] = new Array(n);
    dp[0] = 0;
    for (let i = 1; i < n; i++) {
        dpHas[i] = Math.max(dp[i - 1] - prices[i], dpHas[i - 1]);
        dp[i] = Math.max(dp[i - 1], dpHas[i - 1] + prices[i] - fee);
    }
    return dp[n - 1];
}

console.log(maxProfit([1, 3, 2, 8, 4, 9], 2));
console.log(maxProfit([1, 3, 7, 5, 10, 3], 3));
