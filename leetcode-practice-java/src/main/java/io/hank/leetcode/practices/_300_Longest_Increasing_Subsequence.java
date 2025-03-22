package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * </pre>
 */
public class _300_Longest_Increasing_Subsequence extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    @TimeComplexity(ComplexityType.O_N2)
    @SpaceComplexity(ComplexityType.O_N)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int size : dp) {
            max = Math.max(max, size);
        }
        return max;
    }

    @Topic(TopicType.BINARY_SEARCH)
    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int lengthOfLISBinarySearch(int[] nums) {
        int[] subseq = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(subseq, len, num);
            subseq[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] subseq, int len, int num) {
        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num == subseq[mid]) {
                return mid;
            } else if (num < subseq[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
