package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 10^4].
 * 0 <= Node.val <= 10^5
 * </pre>
 */
public class _530_Min_Absolute_Diff_in_BST extends LeetcodeProblemSolution {
    private TreeNode preNode = null;
    private int diff = Integer.MAX_VALUE;

    @Topic({TopicType.BST, TopicType.DFS})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diff;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (preNode != null) {
            diff = Math.min(diff, node.val - preNode.val);
        }
        preNode = node;
        dfs(node.right);
    }
}
