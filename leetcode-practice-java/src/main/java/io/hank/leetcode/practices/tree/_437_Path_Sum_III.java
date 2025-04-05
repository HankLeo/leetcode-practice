package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.TreeNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.Map;

public class _437_Path_Sum_III extends LeetcodeProblemSolution {
    private int ans;

    @Topic(TopicType.DFS)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int pathSum1(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1); // 初始前缀和为0出现1次
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        s += node.val; // 当前路径前缀和
        // 查找是否存在前缀和为s - targetSum，存在则累加到答案
        ans += cnt.getOrDefault(s - targetSum, 0);
        // 将当前前缀和加入哈希表
        cnt.merge(s, 1, Integer::sum);
        // 递归处理左右子树
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        // 回溯，恢复哈希表状态
        cnt.merge(s, -1, Integer::sum);
    }

    // =========================================================

    @Topic({TopicType.TREE, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumStartWithRoot(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    private int pathSumStartWithRoot(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum) {
            ret++;
        }
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
