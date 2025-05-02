package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * </pre>
 */
public class _114_Flatten_BinaryTree_To_LinkedList extends LeetcodeProblemSolution {

    @Topic({TopicType.DFS, TopicType.TREE})
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(list, root);
        TreeNode dummy = new TreeNode();
        for (TreeNode node : list) {
            dummy.left = null;
            dummy.right = node;
            dummy = node;
        }
    }

    private void dfs(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        dfs(list, node.left);
        dfs(list, node.right);
    }
}
