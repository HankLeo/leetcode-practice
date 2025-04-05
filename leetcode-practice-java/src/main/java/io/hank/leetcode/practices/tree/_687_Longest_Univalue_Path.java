package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 *
 *
 * Example 1:
 *
 * Input: root = [5,4,5,1,1,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value (i.e. 5).
 *
 * Example 2:
 *
 * Input: root = [1,4,5,4,4,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value (i.e. 4).
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
 * </pre>
 */
public class _687_Longest_Univalue_Path extends LeetcodeProblemSolution {

    private int path = 0;

    @Topic(TopicType.DFS)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int longestUnivaluePath1(TreeNode root) {
        dfs(root);
        return path;
    }

    /**
     * Return the lonest path of signle direction with root.
     * Meanwhile, update the longest whole path in DFS.
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = dfs(root.left);
        if (root.left != null && root.val == root.left.val) {
            leftPath++;
        } else {
            leftPath = 0;
        }
        int rightPath = dfs(root.right);
        if (root.right != null && root.val == root.right.val) {
            rightPath++;
        } else {
            rightPath = 0;
        }
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    // =========================================================

    @Topic({TopicType.TREE, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int longestUnivaluePath2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(longestUnivaluePathWithRoot(root), Math.max(longestUnivaluePath2(root.left), longestUnivaluePath2(root.right)));
    }

    private int longestUnivaluePathWithRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = 0, rightPath = 0;
        if (root.left != null) {
            leftPath = root.val == root.left.val
                    ? longestUnivaluePathWithRootAndSignleDirection(root.left) + 1
                    : 0;
        }
        if (root.right != null) {
            rightPath = root.val == root.right.val
                    ? longestUnivaluePathWithRootAndSignleDirection(root.right) + 1
                    : 0;
        }
        return leftPath + rightPath;
    }

    private int longestUnivaluePathWithRootAndSignleDirection(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = 0, rightPath = 0;
        if (root.left != null) {
            leftPath = root.val == root.left.val
                    ? longestUnivaluePathWithRootAndSignleDirection(root.left) + 1
                    : 0;
        }
        if (root.right != null) {
            rightPath = root.val == root.right.val
                    ? longestUnivaluePathWithRootAndSignleDirection(root.right) + 1
                    : 0;
        }
        return Math.max(leftPath, rightPath);
    }
}
