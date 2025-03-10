package io.hank.leetcode.practices;

import java.util.ArrayList;
import java.util.List;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;

/**
 * <pre>
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 * </pre>
 */
public class _95_Unique_Binary_Search_Trees_II extends LeetcodeProblemSolution {

    @Topic({TopicType.RECURSION, TopicType.DP, TopicType.TREE})
    List<TreeNode> generateTrees(int n) {
        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            // The `i` is root node
            List<TreeNode> leftTrees = generateSubTrees(start, i - 1);
            List<TreeNode> rightTrees = generateSubTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i, leftTree, rightTree);
                    res.add(root);
                }
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
