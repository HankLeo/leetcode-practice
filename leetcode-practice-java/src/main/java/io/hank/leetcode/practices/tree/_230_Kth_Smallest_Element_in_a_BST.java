package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 *  Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 * </pre>
 */
public class _230_Kth_Smallest_Element_in_a_BST extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.BST, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countNodes(root.left);
        if (leftCount == k - 1) {
            return root.val;
        }
        if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        }
        return kthSmallest(root.right, k - leftCount - 1);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
