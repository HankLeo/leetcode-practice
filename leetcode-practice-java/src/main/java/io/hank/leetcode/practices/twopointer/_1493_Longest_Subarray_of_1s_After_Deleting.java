package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 *
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 * </pre>
 */
public class _1493_Longest_Subarray_of_1s_After_Deleting extends LeetcodeProblemSolution {

    @Topic(TopicType.SLIDING_WINDOW)
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxLen = 0;
        int curZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                curZeros++;
            }
            // 滑动窗口保证窗口内不超过1个0
            while (curZeros > 1) {
                if (nums[left] == 0) {
                    curZeros--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
            right++;
        }
        return maxLen;
    }
}
