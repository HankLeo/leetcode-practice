package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 *
 * 示例 1:
 *
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 *
 * 示例 3:
 *
 * 输入: root = [], key = 0
 * 输出: []
 *
 *
 * 提示:
 *
 * 节点数的范围 [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 10^5
 * </pre>
 */
public class _450_Delete_Node_in_BST extends LeetcodeProblemSolution {

    @Topic({TopicType.BST, TopicType.RECURSION})
    public TreeNode deleteNode(TreeNode root, int key) {
        // 先找到节点
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 当前节点就是要删除的节点
            // 判断当前节点有没有子节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 如果有双子节点，则把root换成右子树的最小节点
            TreeNode minRight = findMin(root.right);
            root.val = minRight.val;
            root.right = deleteNode(root.right, minRight.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

}
