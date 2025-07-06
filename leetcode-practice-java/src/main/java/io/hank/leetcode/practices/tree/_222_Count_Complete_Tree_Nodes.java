package io.hank.leetcode.practices.tree;

import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 *
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 * </pre>
 */
public class _222_Count_Complete_Tree_Nodes extends LeetcodeProblemSolution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        int leftH = getHeight(root.left);
        while (root != null) {
            int rightH = getHeight(root.right);
            if (leftH == rightH) {
                // 此时左子树一定满
                count += (1 << leftH);
                root = root.right;
            } else {
                // 此时右子数一定满
                count += (1 << rightH);
                root = root.left;
            }
            // 左子树高度只需要-1
            leftH--;
        }
        return count;
    }

    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
