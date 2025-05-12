package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * </pre>
 */
public class _42_Trapping_Rain_Water extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int trap(int[] height) {
        // 使用单调递减栈
        // 当height递减时，无法装雨水
        // 当出现height大于栈顶元素时，先出栈，在判断是否可以装雨水
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break; // 递增情况，左边没有柱子，无法装水
                }
                int h = Math.min(height[i], height[stack.peek()]) - height[top]; // 将水位横着切
                int w = i - stack.peek() - 1;
                res += h * w;
            }
            stack.push(i); // 直到栈内没有小于当前高度，入栈
        }
        return res;
    }
}
