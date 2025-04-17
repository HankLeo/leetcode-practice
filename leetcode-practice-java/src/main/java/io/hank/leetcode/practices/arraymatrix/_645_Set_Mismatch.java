package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 * </pre>
 */
public class _645_Set_Mismatch extends LeetcodeProblemSolution {

    @Topic(TopicType.ARRAY)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int[] findErrorNums(int[] nums) {
        int[] sortedNums = new int[nums.length + 1];
        for (int n : nums) {
            sortedNums[n]++;
        }
        int dup = 0;
        int cor = 0;
        for (int i = 1; i < sortedNums.length; i++) {
            if (sortedNums[i] == 2) {
                dup = i;
            } else if (sortedNums[i] == 0) {
                cor = i;
            } else if (dup != 0 && cor != 0) {
                break;
            }
        }
        return new int[]{dup, cor};
    }
}
