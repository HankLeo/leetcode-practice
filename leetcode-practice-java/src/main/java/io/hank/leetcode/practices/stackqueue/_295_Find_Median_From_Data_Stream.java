package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.PriorityQueue;

/**
 * <pre>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10^-5 以内的答案将被接受。
 *
 * 示例 1：
 *
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 *
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 提示:
 *
 * -10^5 <= num <= 10^5
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 10^4 次调用 addNum 和 findMedian
 * </pre>
 */
public class _295_Find_Median_From_Data_Stream extends LeetcodeProblemSolution {


    static class MedianFinder {
        // 双堆法
        private final PriorityQueue<Integer> minQ;
        private final PriorityQueue<Integer> maxQ;

        public MedianFinder() {
            minQ = new PriorityQueue<>((a, b) -> b - a); // 大顶堆存较小值
            maxQ = new PriorityQueue<>(); // 小顶堆存较大值
        }

        public void addNum(int num) {
            if (minQ.isEmpty() || num < minQ.peek()) {
                minQ.offer(num);
            } else {
                maxQ.offer(num);
            }
            // 平衡双堆，保证较小值数量大于等于较大值
            if (minQ.size() > maxQ.size() + 1) {
                maxQ.offer(minQ.poll());
            } else if (minQ.size() < maxQ.size()) {
                minQ.offer(maxQ.poll());
            }
        }
        
        public double findMedian() {
            if (minQ.size() == maxQ.size()) {
                return (minQ.peek() + maxQ.peek()) / 2.0;
            } else {
                return (double) minQ.peek();
            }
        }
    }

    @Topic(TopicType.HEAP)
    @Override
    public void execute() {
        super.execute();
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
