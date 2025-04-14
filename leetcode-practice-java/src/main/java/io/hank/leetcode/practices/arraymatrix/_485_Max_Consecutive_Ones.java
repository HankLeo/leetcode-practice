package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * </pre>
 */
public class _485_Max_Consecutive_Ones extends LeetcodeProblemSolution {

    @Topic(TopicType.ARRAY)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int curLen = 0;
            while (i < nums.length && nums[i] == 1) {
                curLen++;
                i++;
            }
            count = Math.max(count, curLen);
        }
        return count;
    }
}
