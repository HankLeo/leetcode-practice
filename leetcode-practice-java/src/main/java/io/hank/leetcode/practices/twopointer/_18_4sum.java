package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * </pre>
 */
public class _18_4sum extends LeetcodeProblemSolution {

    @Topic({TopicType.TWO_POINTER})
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) {
            return ans;
        }

        Arrays.sort(nums);
        for (int first = 0; first < n - 3; first++) {
            // 跳过重复答案
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 迭代第二个值
            for (int second = first + 1; second < n - 2; second++) {
                // 跳过重复答案
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                long twoSum = (long) target - nums[first] - nums[second];
                int third = second + 1, forth = n - 1;
                while (third < forth) {
                    // 跳过重复答案
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    int curSum = nums[third] + nums[forth];
                    if (curSum == twoSum) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
                        third++;
                        forth--;
                    } else if (curSum > twoSum) {
                        forth--;
                    } else {
                        third++;
                    }
                }
            }
        }
        return ans;
    }
}
