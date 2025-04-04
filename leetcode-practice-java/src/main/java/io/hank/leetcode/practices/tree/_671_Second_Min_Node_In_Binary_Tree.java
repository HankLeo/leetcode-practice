package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 *
 * Example 1:
 *
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 * Example 2:
 *
 * Input: root = [2,2,2]
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 25].
 * 1 <= Node.val <= 231 - 1
 * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 * </pre>
 */
public class _671_Second_Min_Node_In_Binary_Tree extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        int l = root.left.val;
        int r = root.right.val;
        if (l == root.val) {
            l = findSecondMinimumValue(root.left);
        }
        if (r == root.val) {
            r = findSecondMinimumValue(root.right);
        }
        if (l == -1) {
            return r;
        } else if (r == -1) {
            return l;
        } else {
            return Math.min(l, r);
        }
    }
}
