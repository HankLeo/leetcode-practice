package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -10^5 <= Node.val <= 10^5
 * </pre>
 */
public class _501_Find_Mode_in_BST extends LeetcodeProblemSolution {
    private int maxCount = 0;
    private final List<Integer> list = new ArrayList<>();
    private TreeNode preNode = null;
    private int curCount = 0;

    @Topic({TopicType.BST, TopicType.DFS})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (preNode != null && preNode.val == node.val) {
            curCount++;
        } else {
            curCount = 1;
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            list.clear();
            list.add(node.val);
        } else if (curCount == maxCount) {
            list.add(node.val);
        }
        preNode = node;
        dfs(node.right);
    }
}
