package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

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
