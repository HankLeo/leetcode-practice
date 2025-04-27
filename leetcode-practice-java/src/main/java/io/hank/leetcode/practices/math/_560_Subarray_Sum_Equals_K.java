package io.hank.leetcode.practices.math;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 10$4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * </pre>
 */
public class _560_Subarray_Sum_Equals_K extends LeetcodeProblemSolution {

    @Topic({TopicType.MATH, TopicType.ARRAY, TopicType.HASH})
    public int subarraySum(int[] nums, int k) {
        // [i, ..., j]的和为k，即
        // prevSum[j] - prevSum[i] = k（前缀和）
        int cnt = 0;
        Map<Integer, Integer> prevSumMap = new HashMap<>();
        prevSumMap.put(0, 1);
        int prevSum = 0;
        for (int num : nums) {
            prevSum += num;
            if (prevSumMap.containsKey(prevSum - k)) {
                cnt += prevSumMap.get(prevSum - k);
            }
            if (prevSumMap.containsKey(prevSum)) {
                prevSumMap.put(prevSum, prevSumMap.get(prevSum) + 1);
            } else {
                prevSumMap.put(prevSum, 1);
            }
        }
        return cnt;
    }
}
