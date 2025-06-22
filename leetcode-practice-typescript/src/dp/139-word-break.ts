function wordBreak(s: string, wordDict: string[]): boolean {
    // dp[i] = dp[j] && s[j...i] in wordDict
    const wordSet = new Set(wordDict);
    const len = s.length;
    const dp = new Array(len + 1).fill(false);
    dp[0] = true
    for (let i = 1; i <= len; i++) {
        for (let j = 0; j < i; j++) {
            dp[i] = dp[j] && wordSet.has(s.substring(j, i));
            if (dp[i]) {
                break;
            }
        }
    }
    return dp[len];
}

console.log(wordBreak("leetcode", ["leet", "code"]))
console.log(wordBreak("applepenapple", ["apple", "pen"]))
console.log(wordBreak("catsandog", ["cats", "dog", "sand", "and", "cat"]))
