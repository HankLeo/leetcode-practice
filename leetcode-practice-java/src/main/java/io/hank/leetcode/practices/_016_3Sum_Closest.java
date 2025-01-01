package io.hank.leetcode.practices;

import java.util.Arrays;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

/**
 * <pre>
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * </pre>
 */
public class _016_3Sum_Closest extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N2)
    @SpaceComplexity(ComplexityType.O_1)
    int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        if (result == target) {
            return target;
        }
        int delta = Math.abs(target - result);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int newDelta = 0;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                    newDelta = target - sum;
                } else {
                    k--;
                    newDelta = sum - target;
                }

                if (newDelta < delta) {
                    result = sum;
                    delta = newDelta;
                }
            }
        }

        return result;
    }
}
