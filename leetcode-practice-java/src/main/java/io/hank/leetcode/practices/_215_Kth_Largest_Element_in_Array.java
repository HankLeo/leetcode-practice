package io.hank.leetcode.practices;

import java.util.Arrays;
import java.util.PriorityQueue;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

public class _215_Kth_Largest_Element_in_Array extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    int findKthLargestBySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    @TimeComplexity(ComplexityType.O_N_LOG_K)
    @SpaceComplexity(ComplexityType.O_K)
    int findKthLargestByMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    int findKthLargestByQuickSelect(int[] nums, int k) {
    }
}
