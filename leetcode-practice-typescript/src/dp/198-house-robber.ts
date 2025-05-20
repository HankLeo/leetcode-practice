function rob(nums: number[]): number {
    if (nums.length === 1) {
        return nums[0];
    }
    // dp[i] = max(dp[i - 2] + i, dp[i - 1])
    const dp: number[] = [];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (let i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[nums.length - 1];
}

console.log(rob([1, 2, 3, 1]));
