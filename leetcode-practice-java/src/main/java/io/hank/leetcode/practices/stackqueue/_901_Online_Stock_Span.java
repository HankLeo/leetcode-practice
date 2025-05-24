package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

public class _901_Online_Stock_Span extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    public void testStockSpanner() {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100)); // return 1
        System.out.println(spanner.next(80));  // return 1
        System.out.println(spanner.next(60));  // return 1
        System.out.println(spanner.next(70));  // return 2
        System.out.println(spanner.next(60));  // return 1
        System.out.println(spanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(spanner.next(85));  // return 6
    }
}

class StockSpanner {
    // 单调递减栈, arr[0]表示天数，arr[1]表示值
    private final Deque<int[]> stack;
    private int idx; // 表示天数

    public StockSpanner() {
        stack = new LinkedList<>();
        idx = 0;
    }

    public int next(int price) {
        // 出栈直至peek比price大
        idx++;
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        int cnt = stack.isEmpty() ? idx : idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return cnt;
    }
}
