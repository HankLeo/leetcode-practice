package io.hank.leetcode.practices.recursion;

import io.hank.leetcode.annotations.ComplexityType;
import io.hank.leetcode.annotations.TimeComplexity;
import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 *
 * 示例 1:
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * 示例 2:
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 10^7
 * root 是二叉搜索树
 * 1 <= val <= 10^7
 * </pre>
 */
public class _700_Search_In_a_BST extends LeetcodeProblemSolution {

    @Topic(TopicType.RECURSION)
    @TimeComplexity(ComplexityType.O_LOG_N)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
