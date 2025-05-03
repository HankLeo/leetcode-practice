package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * </pre>
 */
public class _105_Build_BT_From_Preorder_Inorder_Traversal extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.RECURSION})
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int len = preorder.length;
        return mBuildTree(indexMap, preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode mBuildTree(Map<Integer, Integer> indexMap, int[] preorder, int[] inorder, int startPreorder, int endPreorder, int startInorder, int endInorder) {
        if (startPreorder > endPreorder) {
            return null;
        }
        int root = indexMap.get(preorder[startPreorder]);
        TreeNode node = new TreeNode(preorder[startPreorder]);
        // 对inorder进行分区，同时得出preorder的分区索引
        // 左子树
        // startPreorder++;
        // endPreorder = root - startInorder + startPreorder;
        node.left = mBuildTree(indexMap, preorder, inorder, startPreorder + 1, root - startInorder + startPreorder, startInorder, root - 1);
        // 右子树
        // startPreorder = root - startInorder + startPreorder + 1
        node.right = mBuildTree(indexMap, preorder, inorder, root - startInorder + startPreorder + 1, endPreorder, root + 1, endInorder);
        return node;
    }
}
