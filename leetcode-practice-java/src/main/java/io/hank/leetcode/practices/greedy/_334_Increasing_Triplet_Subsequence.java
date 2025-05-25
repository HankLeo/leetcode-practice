package io.hank.leetcode.practices.greedy;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

public class _334_Increasing_Triplet_Subsequence extends LeetcodeProblemSolution {

    @Topic(TopicType.GREEDY)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > second) {
                return true;
            } else if (cur > first) {
                second = cur;
            } else {
                first = cur; // 即便出现2，3，1，4这种情况，也不会影响后续的判断，因为second已经是3了，即使后面出现1，也不会影响second的更新
            }
        }
        return false;
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(increasingTriplet(new int[]{2, 3, 1, 4}));
    }
}
