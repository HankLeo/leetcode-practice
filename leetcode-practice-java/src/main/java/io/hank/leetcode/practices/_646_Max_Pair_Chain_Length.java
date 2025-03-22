package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.Arrays;
import java.util.Comparator;

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
