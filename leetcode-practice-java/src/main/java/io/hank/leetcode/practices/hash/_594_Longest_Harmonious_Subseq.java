package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 *
 * Output: 5
 *
 * Explanation:
 *
 * The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: 2
 *
 * Explanation:
 *
 * The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 *
 * Output: 0
 *
 * Explanation:
 *
 * No harmonic subsequence exists.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * </pre>
 */
public class _594_Longest_Harmonious_Subseq extends LeetcodeProblemSolution {

    @Topic(TopicType.HASH)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findLHS1(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        AtomicInteger max = new AtomicInteger();
        counts.forEach((key, value) -> {
            if (counts.containsKey(key + 1)) {
                max.set(Math.max(max.get(), value + counts.get(key + 1)));
            }
        });
        return max.get();
    }

    @Topic(TopicType.HASH)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int current = countMap.get(key) + countMap.get(key + 1);
                maxLength = Math.max(maxLength, current);
            }
        }
        return maxLength;
    }
}
