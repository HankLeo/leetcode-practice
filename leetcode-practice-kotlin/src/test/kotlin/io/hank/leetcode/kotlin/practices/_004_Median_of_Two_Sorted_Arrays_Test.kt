package io.hank.leetcode.kotlin.practices

import kotlin.test.Test
import kotlin.test.assertEquals

class _004_Median_of_Two_Sorted_Arrays_Test {
    private val solution = _004_Median_of_Two_Sorted_Arrays()

    @Test
    fun `test with two small sorted arrays`() {
        val nums1 = intArrayOf(1, 3)
        val nums2 = intArrayOf(2)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(2.0, result)
    }

    @Test
    fun `test with even total number of elements`() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(3, 4)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(2.5, result)
    }

    @Test
    fun `test with one empty array`() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf(1, 2, 3, 4)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(2.5, result)
    }

    @Test
    fun `test with both arrays containing single elements`() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf(2)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(1.5, result)
    }

    @Test
    fun `test with negative numbers`() {
        val nums1 = intArrayOf(-5, -3, -1)
        val nums2 = intArrayOf(-4, -2, 0)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(-2.5, result)
    }

    @Test
    fun `test with larger sorted arrays`() {
        val nums1 = intArrayOf(1, 2, 3, 6, 8)
        val nums2 = intArrayOf(4, 5, 7, 9, 10)
        val result = solution.findMedianSortedArrays(nums1, nums2)
        assertEquals(5.5, result)
    }
}
