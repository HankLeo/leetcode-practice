package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * </pre>
 */
public class _228_Summary_Ranges extends LeetcodeProblemSolution {

    @Topic(TopicType.TWO_POINTER)
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        if (len == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }

        // 双指针
        int left = 0, right = 1;
        while (right < len) {
            int prev = left;
            while (right < len && nums[left] + 1 == nums[right]) {
                left++;
                right++;
            }
            StringBuilder period = new StringBuilder();
            period.append(nums[prev]);
            if (prev != left) {
                period.append("->");
                period.append(nums[left]);
            }
            ans.add(period.toString());
            if (right == len - 1) {
                ans.add(String.valueOf(nums[right]));
                break;
            }
            left++;
            right++;
        }
        return ans;
    }
}
