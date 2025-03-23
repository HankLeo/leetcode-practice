package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 * You are given an array of n pairs pairs where pairs[i] = [left_i, right_i] and left_i < right_i.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 *
 * Example 2:
 *
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 *
 *
 * Constraints:
 *
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= left_i < right_i <= 1000
 * </pre>
 */
public class _646_Max_Pair_Chain_Length extends LeetcodeProblemSolution {

    @Topic(TopicType.GREEDY)
    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int right = Integer.MIN_VALUE;
        int len = 0;
        for (int[] pair : pairs) {
            if (pair[0] > right) {
                right = pair[1];
                len++;
            }
        }
        return len;
    }
}
