/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * <p>
 * Output: "bb"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * <p>
 * s consist of only digits and English letters.
 */
function longestPalindrome(s: string): string {
    if (s.length < 2) {
        return s;
    }

    const sb = ['#'];
    for (const c of s) {
        sb.push(c);
        sb.push('#');
    }
    const processed = sb.join('');

    const n = processed.length;
    let maxCenter = 0;
    let maxLength = 0;
    let center = 0;
    let right = 0;
    const dp = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        if (i < right) {
            dp[i] = Math.min(dp[2 * center - i], right - i);
        }

        while (
            dp[i] < i &&
            i + dp[i] < n - 1 &&
            processed.charAt(i - dp[i] - 1) === processed.charAt(i + dp[i] + 1)
        ) {
            dp[i]++;
        }

        if (i + dp[i] > right) {
            center = i;
            right = i + dp[i];
        }

        if (dp[i] > maxLength) {
            maxLength = dp[i];
            maxCenter = i;
        }
    }

    const realCenter = (maxCenter - maxLength) / 2;
    return s.substring(realCenter, realCenter + maxLength);
}

export function execute() {
    console.log('==== Problem: _005_Longest_Palindromic_Substring ====');

    // Example 1
    let s = 'babad';
    console.log(`Input: s = ${s}`);
    console.log(`Output: ${longestPalindrome(s)}`);

    // Example 2
    s = 'ss';
    console.log(`Input: s = ${s}`);
    console.log(`Output: ${longestPalindrome(s)}`);

    // Example 3
    s = 'cbbd';
    console.log(`Input: s = ${s}`);
    console.log(`Output: ${longestPalindrome(s)}`);
}
