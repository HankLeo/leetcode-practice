package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 * Example 1:
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 *  Example 2:
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 * </pre>
 */
public class _337_House_Robber_III extends LeetcodeProblemSolution {

    @Topic({TopicType.DP, TopicType.TREE, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int rob1(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 递归处理左右子树
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        // res[0] 表示不偷当前节点的最大值，res[1] 表示偷当前节点的最大值
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }

    private final Map<TreeNode, Integer> cache = new HashMap<>();

    @Topic({TopicType.TREE, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.get(root) != null) {
            return cache.get(root);
        }
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            val1 += rob2(root.right.left) + rob2(root.right.right);
        }
        int val2 = rob2(root.left) + rob2(root.right);
        int result = Math.max(val1, val2);
        cache.put(root, result);
        return result;
    }
}
