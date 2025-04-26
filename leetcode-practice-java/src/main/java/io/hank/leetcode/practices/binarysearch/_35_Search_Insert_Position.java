package io.hank.leetcode.practices.binarysearch;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为 无重复元素 的 升序 排列数组
 * -10^4 <= target <= 10^4
 * </pre>
 */
public class _35_Search_Insert_Position extends LeetcodeProblemSolution {

    @Topic(TopicType.BINARY_SEARCH)
    @TimeComplexity(ComplexityType.O_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (target > nums[high]) {
            return nums.length;
        }
        if (target < nums[low]) {
            return 0;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
