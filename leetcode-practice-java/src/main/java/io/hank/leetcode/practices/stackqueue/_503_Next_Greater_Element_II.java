package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * </pre>
 */
public class _503_Next_Greater_Element_II extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> indexes = new LinkedList<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len * 2 - 1; i++) {
            int index = i >= len ? i - len : i;
            while (!indexes.isEmpty() && nums[index] > nums[indexes.peek()]) {
                int prevIndex = indexes.pop();
                res[prevIndex] = nums[index];
            }
            indexes.push(index);
        }
        return res;
    }
}
