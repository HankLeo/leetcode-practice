package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * </pre>
 */
public class _040_Combination_Sum_II extends LeetcodeProblemSolution {

    @Topic(TopicType.BACKTRACK)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, result, path, 0, used);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int start, boolean[] used) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && !used[i - 1] && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (candidates[i] <= target) {
                used[i] = true;
                path.add(candidates[i]);
                backtrack(candidates, target - candidates[i], result, path, i + 1, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
