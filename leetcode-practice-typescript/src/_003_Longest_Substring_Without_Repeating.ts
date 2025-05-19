/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * <p>
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * <p>
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
function lengthOfLongestSubstring(s: string): number {
    let maxLength = 0;
    const charIndex: number[] = [];
    charIndex.fill(-1, 0, 127);
    let left = 0;

    for (let right = 0; right < s.length; right++) {
        if (charIndex[s.charCodeAt(right)] >= left) {
            left = charIndex[s.charCodeAt(right)] + 1;
        }
        charIndex[s.charCodeAt(right)] = right;
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

export function execute() {
    console.log('Problem: _003_Longest_Substring_Without_Repeating');

    const input1 = 'abcabcbb';
    console.log(`Input: s = ${input1}`);
    console.log(`Output: ${lengthOfLongestSubstring(input1)}`);

    const input2 = 'bbbbb';
    console.log(`Input: s = ${input2}`);
    console.log(`Output: ${lengthOfLongestSubstring(input2)}`);

    const input3 = 'pwwkew';
    console.log(`Input: s = ${input3}`);
    console.log(`Output: ${lengthOfLongestSubstring(input3)}`);
}
