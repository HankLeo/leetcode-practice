package io.hank.leetcode.practices.search;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 * </pre>
 */
public class _279_Perfect_Squares extends LeetcodeProblemSolution {

    @Topic({TopicType.BFS, TopicType.TREE})
    @TimeComplexity(ComplexityType.O_NSqrtN)
    @SpaceComplexity(ComplexityType.O_N)
    public int numSquares(int n) {
        int[] squares = generateSquares(n);
        int res = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            // 遍历每一层
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int square : squares) {
                    // 先到达的层数即为答案
                    if (square == num) {
                        return res;
                    }
                    int diff = num - square;
                    if (diff > 0 && !visited[diff]) {
                        // 标记已访问
                        visited[diff] = true;
                        queue.offer(diff);
                    }
                    if (diff < 0) {
                        break;
                    }
                }
            }
        }
        return res;
    }

    private int[] generateSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[] squares = new int[sqrt];
        for (int i = 1; i <= sqrt; i++) {
            squares[i - 1] = i * i;
        }
        return squares;
    }
}
