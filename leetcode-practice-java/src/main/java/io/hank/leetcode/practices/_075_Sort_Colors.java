package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

public class _075_Sort_Colors extends LeetcodeProblemSolution {
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    void sortColors(int[] nums) {
        // 3 pointers
        int low = -1, mid = 0, high = nums.length;
        while (mid < high) {
            if (nums[mid] == 0) {
                // move low pointer to be right of 0
                swap(nums, ++low, mid++);
            } else if (nums[mid] == 2) {
                // move high pointer to be left of 2
                swap(nums, mid, --high);
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
