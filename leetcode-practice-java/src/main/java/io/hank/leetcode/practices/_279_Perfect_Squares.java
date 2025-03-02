package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    int maxSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        boolean[] visited = new boolean[n + 1];
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int square : squares) {
                    int next = cur - square;
                    if (next == 0) {
                        return level;
                    }
                    if (next > 0 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return 0;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            squares.add(i * i);
        }
        return squares;
    }
}
