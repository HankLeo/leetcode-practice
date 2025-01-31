package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

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
