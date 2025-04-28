package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 * </pre>
 */
public class _152_Max_Product_Subarray extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int maxProduct(int[] nums) {
        // max(n) = Math.max(max(n - 1) * n, min(n - 1) * n, n)
        // min(n) = Math.min(min(n - 1) * n, max(n - 1) * n, n)
        long[] maxNums = new long[nums.length];
        maxNums[0] = nums[0];
        long[] minNums = new long[nums.length];
        minNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNums[i] = Math.max(maxNums[i - 1] * nums[i], Math.max(minNums[i - 1] * nums[i], nums[i]));
            minNums[i] = Math.min(maxNums[i - 1] * nums[i], Math.min(minNums[i - 1] * nums[i], nums[i]));
        }
        long max = Integer.MIN_VALUE;
        for (long num : maxNums) {
            max = Math.max(max, num);
        }
        return (int) max;
    }
}
