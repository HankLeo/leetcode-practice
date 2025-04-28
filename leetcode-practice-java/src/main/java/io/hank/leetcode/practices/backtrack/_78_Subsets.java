package io.hank.leetcode.practices.backtrack;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * </pre>
 */
public class _78_Subsets extends LeetcodeProblemSolution {

    @Topic({TopicType.BACKTRACK, TopicType.DFS, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_2N)
    @SpaceComplexity(ComplexityType.O_N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        backtrack(nums, 0, curList, res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> curList, List<List<Integer>> res) {
        res.add(new ArrayList<>(curList));

        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack(nums, i + 1, curList, res); // 直接往后加1，替代标记
            curList.removeLast();
        }
    }
}
