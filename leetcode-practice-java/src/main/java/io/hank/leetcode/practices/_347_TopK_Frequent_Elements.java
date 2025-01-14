package io.hank.leetcode.practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 */
public class _347_TopK_Frequent_Elements extends LeetcodeProblemSolution {
    int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // freq can be o..nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        freqMap.forEach((num, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        });
        List<Integer> topK = new ArrayList<>();
        for (int i = nums.length; i > 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                if (buckets[i].size() <= k - topK.size()) {
                    topK.addAll(buckets[i]);
                } else {
                    topK.addAll(buckets[i].subList(0, k - topK.size()));
                }
            }
        }
        return topK.stream().mapToInt(i -> i).toArray();
    }
}
