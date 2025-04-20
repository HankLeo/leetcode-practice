package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * </pre>
 */
public class _697_Degree_of_an_Array extends LeetcodeProblemSolution {

    @Topic({TopicType.ARRAY, TopicType.HASH})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                Node node = map.get(n);
                node.endIndex = i;
                node.cnt++;
            } else {
                map.put(n, new Node(i, i, 1));
            }
        }
        int maxCnt = 0;
        int res = nums.length;
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            int range = node.endIndex - node.startIndex + 1;
            if (node.cnt > maxCnt) {
                maxCnt = node.cnt;
                res = range;
            } else if (node.cnt == maxCnt && range < res) {
                res = range;
            }
        }
        return res;
    }

    static class Node {
        int startIndex;
        int endIndex;
        int cnt;

        public Node(int start, int end, int cnt) {
            this.startIndex = start;
            this.endIndex = end;
            this.cnt = cnt;
        }
    }
}
