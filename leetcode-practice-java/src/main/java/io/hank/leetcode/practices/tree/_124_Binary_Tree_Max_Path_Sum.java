package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 示例 2：
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * </pre>
 */
public class _124_Binary_Tree_Max_Path_Sum extends LeetcodeProblemSolution {
    int maxSum = Integer.MIN_VALUE;

    @Topic({TopicType.RECURSION, TopicType.TREE})
    public int maxPathSum(TreeNode root) {
        maxPathSumWithRoot(root);
        return maxSum;
    }

    private int maxPathSumWithRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 忽略总和为负数的路径
        int maxLeft = Math.max(maxPathSumWithRoot(root.left), 0);
        int maxRight = Math.max(maxPathSumWithRoot(root.right), 0);
        int sum = root.val + maxLeft + maxRight;
        maxSum = Math.max(maxSum, sum); // 判断当前路径是否是最大值
        return root.val + Math.max(maxLeft, maxRight); // 只能访问左右子树中的一条路径保证继续递归
    }
}
