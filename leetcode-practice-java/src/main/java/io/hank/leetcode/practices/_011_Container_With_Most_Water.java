package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

public class _011_Container_With_Most_Water extends LeetcodeProblemSolution {

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
