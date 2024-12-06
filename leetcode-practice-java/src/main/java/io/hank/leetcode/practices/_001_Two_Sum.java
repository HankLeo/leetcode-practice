package io.hank.leetcode.practices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * <p>
 * Output: [0,1]
 * <p>
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * <p>
 * Output: [1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * <p>
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * <p>
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * -10^9 <= target <= 10^9
 * <p>
 * Only one valid answer exists.
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class _001_Two_Sum {
    public void execute() {
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1));

        int[] result2 = twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(result2));

        int[] result3 = twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(result3));
    }

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};                
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // no matched
    }
}
