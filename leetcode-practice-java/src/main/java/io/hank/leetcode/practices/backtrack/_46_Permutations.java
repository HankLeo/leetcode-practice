package io.hank.leetcode.practices.backtrack;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * </pre>
 */
public class _46_Permutations extends LeetcodeProblemSolution {

    @Topic(TopicType.BACKTRACK)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
//            result.add(Arrays.stream(nums).boxed().toList()); too slow
            List<Integer> list = new ArrayList<>(nums.length);
            for (int n : nums) {
                list.add(n);
            }
            result.add(list);
            return;
        }

        //DFS
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            backtrack(result, nums, start + 1);
            // backtrack
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Topic({TopicType.BACKTRACK, TopicType.DFS, TopicType.RECURSION})
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> curList = new ArrayList<>();
        backtrack2(nums, visited, curList, res);
        return res;
    }

    private void backtrack2(int[] nums, boolean[] visited, List<Integer> curList, List<List<Integer>> res) {
        if (curList.size() == nums.length) {
            res.add(new ArrayList<>(curList));
        }

        // loop all start points or recursive points
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curList.add(nums[i]);
                // mark
                visited[i] = true;
                // recursion
                backtrack2(nums, visited, curList, res);
                // backtrack
                curList.removeLast();
                visited[i] = false;
            }
        }
    }
}
