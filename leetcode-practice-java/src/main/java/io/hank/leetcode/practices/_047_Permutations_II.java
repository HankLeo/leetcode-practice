package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * </pre>
 */
public class _047_Permutations_II extends LeetcodeProblemSolution {

    @Topic(TopicType.BACKTRACK)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(nums.length), new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
//            result.add(path); wrong answer!!! the path will be changed in the backtracking, not to use reference
            // so we need to copy a new list
            result.add(new ArrayList<>(path));
            return;
        }

        // DFS
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // not used means prev element is back tracked
            // so no need to set same root element
            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, result, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
