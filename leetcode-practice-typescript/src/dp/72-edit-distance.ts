function minDistance(word1: string, word2: string): number {
    // dp[i][j]
    // if word[i] = word[j]
    // if word[i] != word[j]
    const m = word1.length;
    const n = word2.length;
    const dp = [];
    for (let i = 0; i <= m; i++) {
        dp.push(new Array(n + 1))
    }
    for (let i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (let j = 1; j <= n; j++) {
        dp[0][j] = j;
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (word1[i - 1] === word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
    }
    return dp[m][n];
}

console.log(minDistance("horse", "ros"))
console.log(minDistance("intention", "execution"))
