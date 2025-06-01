package io.hank.leetcode.practices.tree;

import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

public class _1372_Longest_Zigzag_Path_in_BT extends LeetcodeProblemSolution {

    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLen;
    }

    private void dfs(TreeNode root, boolean isLeft, int curLen) {
        maxLen = Math.max(maxLen, curLen);
        if (isLeft) {
            if (root.left != null) {
                // 找到左边点并继续迭代
                dfs(root.left, false, curLen + 1);
            }
            if (root.right != null) {
                // 对于右节点重新计算
                dfs(root.right, true, 1);
            }
        } else {
            if (root.left != null) {
                // 对于左节点重新计算
                dfs(root.left, false, 1);
            }
            if (root.right != null) {
                // 找到右边点并继续迭代
                dfs(root.right, true, curLen + 1);
            }
        }
    }
}
