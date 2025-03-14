package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * <p>
 * Output: 2.00000
 * <p>
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * <p>
 * Output: 2.50000
 * <p>
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class _4_Median_of_Two_Sorted_Arrays extends LeetcodeProblemSolution {

    @Topic(TopicType.BINARY_SEARCH)
    @TimeComplexity(ComplexityType.O_LOG_M_DIVIDE_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        // make array 1 shorter than array 2
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int leftSize = (n + 1) >> 1;
        int low = 0;
        int high = n1;
        int mid1, mid2;
        int l1, l2, r1, r2;

        while (low <= high) {
            // use binary search
            mid1 = (low + high) >> 1;
            mid2 = leftSize - mid1;

            r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;
            l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                // correct result
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            } else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // fallback
    }

    @Override
    public void execute() {
        super.execute();

        int[] nums1, nums2;

        // Example 1
        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMedianSortedArrays(nums1, nums2));

        // Example 2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMedianSortedArrays(nums1, nums2));
    }
}
