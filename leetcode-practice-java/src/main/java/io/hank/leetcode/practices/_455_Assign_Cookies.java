package io.hank.leetcode.practices;

import java.util.Arrays;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.SpaceComplexity;
import io.hank.leetcode.annotations.TimeComplexity;

public class _455_Assign_Cookies extends LeetcodeProblemSolution {
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
