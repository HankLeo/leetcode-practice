package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * 示例 1:
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *
 *
 * 提示：
 *
 * 1 <= heights.length <=10^5
 * 0 <= heights[i] <= 10^4
 * </pre>
 */
public class _84_Largest_Rectangle_In_Histogram extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public int largestRectangleArea(int[] heights) {
        // 使用递增单调栈
        // 如果高度下降则出栈
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int right = 0; right <= heights.length; right++) {
            // 增加一个哨兵，保证全部出栈
            int curH = right == heights.length ? 0 : heights[right];
            // 如果当前高度小于栈顶，则先出栈并计算面积
            while (!stack.isEmpty() && curH < heights[stack.peek()]) {
                int top = stack.pop();
                int h = heights[top];
                int w = stack.isEmpty() ? right : right - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(right);
        }
        return maxArea;
    }
}
