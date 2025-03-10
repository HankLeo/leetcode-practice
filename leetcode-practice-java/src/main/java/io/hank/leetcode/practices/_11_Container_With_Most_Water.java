package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.SpaceComplexity;
import io.hank.leetcode.annotations.TimeComplexity;

public class _11_Container_With_Most_Water extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxContainer = 0;

        while (left < right) {
            int currentContainer = Math.min(height[left], height[right]) * (right - left);
            maxContainer = Math.max(maxContainer, currentContainer);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxContainer;
    }

}
