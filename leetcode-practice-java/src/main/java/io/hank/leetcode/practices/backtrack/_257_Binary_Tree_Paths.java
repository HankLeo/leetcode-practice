package io.hank.leetcode.practices.backtrack;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * </pre>
 */
public class _257_Binary_Tree_Paths extends LeetcodeProblemSolution {

    @Topic(TopicType.BACKTRACK)
    List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(root, result, path);
        return result;
    }

    private void backtrack(TreeNode node, List<String> result, List<String> path) {
        path.add(String.valueOf(node.val));
        // end recursion
        if (node.left == null && node.right == null) {
            result.add(String.join("->", path));
            return;
        }
        // DFS
        if (node.left != null) {
            backtrack(node.left, result, path);
            path.removeLast();
        }
        if (node.right != null) {
            backtrack(node.right, result, path);
            path.removeLast();
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
