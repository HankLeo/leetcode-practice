package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

public class _80__26_Remove_Duplicates_From_Sorted_Array_II extends LeetcodeProblemSolution {

    @Topic(TopicType.TWO_POINTER)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int slow = 2; // 从第三个元素开始处理
        for (int fast = 2; fast < nums.length; fast++) {
            // 只有当当前元素不等于 slow-2 位置的元素时才保留
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; // 新数组长度
    }
}
