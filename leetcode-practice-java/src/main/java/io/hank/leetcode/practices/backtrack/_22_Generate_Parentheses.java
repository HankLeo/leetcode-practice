package io.hank.leetcode.practices.backtrack;

import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * </pre>
 */
public class _22_Generate_Parentheses extends LeetcodeProblemSolution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int n, int lefts, int rights) {
        if (lefts + rights == 2 * n) {
            res.add(new String(sb));
            return;
        }
        if (lefts < n) {
            sb.append('(');
            backtrack(res, sb, n, lefts + 1, rights);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rights < lefts) {
            sb.append(')');
            backtrack(res, sb, n, lefts, rights + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
