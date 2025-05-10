package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <pre>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * </pre>
 */
public class _239_Sliding_Window_Max extends LeetcodeProblemSolution {

    @Topic({TopicType.STACK, TopicType.QUEUE})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_K)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 双端队列存每个滑动窗口内最大值的索引
        // 若递减 则逐个入栈
        // 若递增 则逐个出栈
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peek()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }

    @Topic(TopicType.QUEUE)
    @TimeComplexity(ComplexityType.O_N_LOG_K)
    @SpaceComplexity(ComplexityType.O_K)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 大顶堆 {number, index}
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.number != b.number ? b.number - a.number : a.index - b.index);
        for (int i = 0; i < k; i++) {
            queue.offer(new Pair(nums[i], i));
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek().number;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new Pair(nums[i], i));
            // 如果最大值在窗口外，出队列
            while (queue.peek().index <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek().number;
        }
        return res;
    }

    static class Pair {
        int number;
        int index;

        public Pair(int num, int i) {
            number = num;
            index = i;
        }
    }
}
