package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 给定一个整数数组 asteroids，表示在同一行的小行星。数组中小行星的索引表示它们在空间中的相对位置。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 *
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 *
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 *
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * </pre>
 */
public class _735_Asteroid_Collision extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int a : asteroids) {
            if (stack.isEmpty() || a > 0) {
                stack.push(a);
            } else {
                boolean needPush = true; // 默认需要压入栈，除非被撞毁或抵消
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top > -a) {
                        // 栈顶大，当前小行星撞毁，不压栈
                        needPush = false;
                        break;
                    } else if (top == -a) {
                        // 相等，两个都撞毁，不压栈
                        stack.pop(); // 弹出栈顶
                        needPush = false;
                        break;
                    } else {
                        // 栈顶小，弹出栈顶，继续比较下一个
                        stack.pop();
                    }
                }
                if (needPush) {
                    stack.push(a);
                }
            }
        }

        // 把栈中元素转成数组（注意顺序）
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pollLast();
            i++;
        }
        return res;
    }
}
