package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
 *
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * Return the list answer. If there multiple valid answers, return any of them.
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 1
 * Output: [1,2,3]
 * Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
 *
 * Example 2:
 *
 * Input: n = 3, k = 2
 * Output: [1,3,2]
 * Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 *
 *
 * Constraints:
 *
 * 1 <= k < n <= 10^4
 * </pre>
 */
public class _667_Beautiful_Arrangement_II extends LeetcodeProblemSolution {

    @Topic({TopicType.ARRAY, TopicType.MATH})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        // 1, k + 1, 2, k, 3, ... , i + 1, i + 2, ...
        int val1 = 1;
        int val2 = k + 1;
        int i = 0;
        while (i < n && val1 <= val2) {
            if (i % 2 == 0) {
                res[i] = val1;
                val1++;
            } else {
                res[i] = val2;
                val2--;
            }
            i++;
        }
        while (i < n) {
            res[i] = ++i;
        }
        return res;
    }
}
