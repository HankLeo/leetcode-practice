package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You cannot get a non-decreasing array by modifying at most one element.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 10^4
 * -105 <= nums[i] <= 10^5
 * </pre>
 */
public class _665_Non_decreasing_Array extends LeetcodeProblemSolution {

    @Topic(TopicType.GREEDY)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count > 0) {
                    return false;
                }
                if (i > 1 && nums[i] < nums[i - 2]) {
                    // only care the change of nums[i]
                    // if nums[i - 2] less than nums[i], just set nums[i - 1] as nums[i - 2]
                    // it will not impact next comparison
                    nums[i] = nums[i - 1];
                }
                count++;
            }
        }
        return true;
    }
}
