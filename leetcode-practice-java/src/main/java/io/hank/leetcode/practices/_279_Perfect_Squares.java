package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _279_Perfect_Squares extends LeetcodeProblemSolution {

    @Topic(TopicType.BFS)
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
