package io.hank.leetcode.kotlin.practices

class _004_Median_of_Two_Sorted_Arrays : LeetcodeProblemSolution() {
    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n1 = nums1.size
        val n2 = nums2.size
        val n = n1 + n2

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val leftArraySize = (n + 1) / 2
        var left = 0
        var right = n1

        while (left <= right) {
            val mid1 = (left + right) / 2
            val mid2 = leftArraySize - mid1

            val l1 = if ((mid1 - 1) >= 0) nums1[mid1 - 1] else Int.MIN_VALUE
            val r1 = if (mid1 < n1) nums1[mid1] else Int.MAX_VALUE
            val l2 = if ((mid2 - 1) >= 0) nums2[mid2 - 1] else Int.MIN_VALUE
            val r2 = if (mid2 < n2) nums2[mid2] else Int.MAX_VALUE

            if (l1 <= r2 && l2 <= r1) {
                // correct answer here
                return if (n % 2 == 1) l1.coerceAtLeast(l2).toDouble()
                else (l1.coerceAtLeast(l2) + r1.coerceAtMost(r2)) / 2.0
            } else if (l1 > r2) {
                // too large in left nums1
                right = mid1 - 1
            } else {
                // too small in left nums1
                left = mid1 + 1
            }
        }

        return 0.0 // fallback
    }

    override fun execute() {
        super.execute()

        // Example 1
        var nums1: IntArray = intArrayOf(1, 3)
        var nums2: IntArray = intArrayOf(2)
        println("Input: nums1=${nums1.contentToString()}, nums2=${nums2.contentToString()}")
        println("Output: ${findMedianSortedArrays(nums1, nums2)}")

        // Example 2
        nums1 = intArrayOf(1, 2)
        nums2 = intArrayOf(3, 4)
        println("Input: nums1=${nums1.contentToString()}, nums2=${nums2.contentToString()}")
        println("Output: ${findMedianSortedArrays(nums1, nums2)}")
    }
}
