package io.hank.leetcode.practices.greedy;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;

public class _455_Assign_Cookies extends LeetcodeProblemSolution {
    @Topic(TopicType.GREEDY)
    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_1)
    int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        // sort the g & s
        Arrays.sort(g);
        Arrays.sort(s);

        // iterate the s
        int result = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
            }
            j++;
        }
        return result;
    }
}
