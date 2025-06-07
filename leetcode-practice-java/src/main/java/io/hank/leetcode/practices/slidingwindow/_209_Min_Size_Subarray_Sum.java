package io.hank.leetcode.practices.slidingwindow;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * </pre>
 */
public class _209_Min_Size_Subarray_Sum extends LeetcodeProblemSolution {

    @Topic(TopicType.SLIDING_WINDOW)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int left = 0, right = 0;
        int len = nums.length + 1;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return len == nums.length + 1 ? 0 : len;
    }
}
