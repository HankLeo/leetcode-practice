package io.hank.leetcode.practices.sort;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.TimeComplexity;
import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <pre>
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * 提示:
 *
 * 1 <= nums1.length, nums2.length <= 10^5
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1 和 nums2 均为 升序排列
 * 1 <= k <= 10^4
 * k <= nums1.length * nums2.length
 * </pre>
 */
public class _373_Find_K_Pairs_with_Smallest_Sums extends LeetcodeProblemSolution {

    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N_LOG_K)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存储数对的和以及对应的索引 (sum, i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);
        // 初始填充：将nums1的每个元素与nums2的第一个元素组成的数对加入堆
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        // 每次从堆中取出和最小的数对，将其加入结果列表，然后将nums1的当前元素与nums2的下一个元素组成的数对加入堆中
        List<List<Integer>> ans = new ArrayList<>();
        while (ans.size() < k) {
            int[] minArray = minHeap.poll();
            int i = minArray[1], j = minArray[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }
}
