package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 *
 * Output: [3,2,1]
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 *
 * Output: [4,6,7,5,2,9,8,3,1]
 *
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 *
 * Example 4:
 *
 * Input: root = [1]
 *
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * </pre>
 */
public class _145_Binary_Tree_Postorder_Traversal extends LeetcodeProblemSolution {

    @Topic({TopicType.DFS, TopicType.TREE})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        // 左右根取反得根右左
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            result.add(0, node.val); // 取反则倒着插入，结果顺序正确
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }
        return result;
    }
}
