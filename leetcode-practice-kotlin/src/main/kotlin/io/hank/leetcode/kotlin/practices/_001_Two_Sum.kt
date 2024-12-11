package io.hank.leetcode.kotlin.practices

import java.util.*

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 *
 * Output: [0,1]
 *
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 *
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 *
 * Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 10^4
 *
 * -10^9 <= nums[i] <= 10^9
 *
 * -10^9 <= target <= 10^9
 *
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
class _001_Two_Sum : LeetcodeProblemSolution() {
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = HashMap<Int, Int>()
        nums.forEachIndexed { index, element ->
            val complement = target - element
            numMap.takeIf { it.containsKey(complement) }?.let { map ->
                return intArrayOf(map[complement] ?: 0, index)
            }
            numMap[nums[index]] = index
        }
        return intArrayOf()
    }

    override fun execute() {
        super.execute()

        // Example 1
        val input1 = intArrayOf(2, 7, 11, 15)
        val target1 = 9
        println("Input: nums = ${input1.contentToString()}, target = $target1")
        val result1 = twoSum(input1, target1)
        println("Output: ${result1.contentToString()}")

        // Example 2
        val input2 = intArrayOf(2, 3, 4)
        val target2 = 6
        println("Input: nums = ${input2.contentToString()}, target = $target2")
        val result2 = twoSum(input2, target2)
        println("Output: ${result2.contentToString()}")

        // Example 1
        val input3 = intArrayOf(3, 3)
        val target3 = 6
        println("Input: nums = ${input3.contentToString()}, target = $target3")
        val result3 = twoSum(input3, target3)
        println("Output: ${result3.contentToString()}")
    }
}
