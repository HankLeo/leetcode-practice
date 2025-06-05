function climbStairs(n: number): number {
    // dp[i] = dp[i - 1] + dp[i - 2]
    const dp: number[] = new Array(n + 1);
    dp[0] = 1;
    dp[1] = 1;
    for (let i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
