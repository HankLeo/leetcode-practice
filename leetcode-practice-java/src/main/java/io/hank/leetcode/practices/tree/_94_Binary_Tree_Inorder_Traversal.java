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
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 *
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 *
 * Output: [4,2,6,5,7,1,3,9,8]
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
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </pre>
 */
public class _94_Binary_Tree_Inorder_Traversal extends LeetcodeProblemSolution {

    @Topic({TopicType.DFS, TopicType.TREE})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
