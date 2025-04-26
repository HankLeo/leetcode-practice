package io.hank.leetcode.practices.dp;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 * </pre>
 */
public class _118_Pascal_Triangle extends LeetcodeProblemSolution {

    @Topic(TopicType.DP)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        res.add(list0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>(i + 1);
            curList.add(1);
            List<Integer> prevList = res.get(i - 1);
            for (int j = 1; j < prevList.size(); j++) {
                curList.add(prevList.get(j - 1) + prevList.get(j));
            }
            curList.add(1);
            res.add(curList);
        }
        return res;
    }
}
