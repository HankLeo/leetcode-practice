package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: 1
 *
 *  Example 2:
 *
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 * </pre>
 */
public class _513_Find_Bottom_Left_Tree_Value extends LeetcodeProblemSolution {

    @Topic({TopicType.BFS, TopicType.TREE})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    // first node of level
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
