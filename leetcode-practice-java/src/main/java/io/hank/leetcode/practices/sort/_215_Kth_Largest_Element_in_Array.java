package io.hank.leetcode.practices.sort;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <pre>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * </pre>
 */
public class _215_Kth_Largest_Element_in_Array extends LeetcodeProblemSolution {

    // 快速排序
    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    int findKthLargestBySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 小顶堆
    @Topic({TopicType.SORT_AND_SELECTION, TopicType.HEAP})
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

    // 桶排序
    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findKthLargestByBucket(int[] nums, int k) {
        // -10^4 <= nums[i] <= 10^4
        // 桶排序
        int[] bucket = new int[20001];
        for (int num : nums) {
            bucket[num + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k -= bucket[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return -1000; // 实际不会执行
    }

    // 快速选择
    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    int findKthLargestByQuickSelect(int[] nums, int k) {
        int targetIndex = nums.length - k;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int partition = partition(nums, start, end);
            if (partition == targetIndex) {
                break;
            } else if (partition < targetIndex) {
                start = partition + 1;
            } else {
                end = partition - 1;
            }
        }
        return nums[targetIndex];
    }

    private int partition(int[] nums, int start, int end) {
        // use start index as pivot
        int i = start, j = end + 1;
        while (true) {
            while (nums[++i] < nums[start] && i < end) ;
            while (nums[--j] > nums[start] && j > start) ;
            if (i >= j) {
                break;
            }
            if (nums[i] == nums[j]) {
                continue;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
