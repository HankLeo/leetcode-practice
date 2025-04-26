package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * </pre>
 */
public class _102_Binary_Tree_Level_Order_Traversal extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.BFS})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                // swap queue1 and queue2 when new level comes
                queue1 = queue2;
                queue2 = new LinkedList<>();
                list = new ArrayList<>();
                res.add(list);
            }
            TreeNode cur = queue1.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue2.offer(cur.left);
            }
            if (cur.right != null) {
                queue2.offer(cur.right);
            }
        }
        return res;
    }
}
