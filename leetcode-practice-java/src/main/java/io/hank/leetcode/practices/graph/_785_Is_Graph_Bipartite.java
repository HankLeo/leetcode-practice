package io.hank.leetcode.practices.graph;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 *
 *
 * Example 1:
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 *
 * Example 2:
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 *
 *
 * Constraints:
 *
 * graph.length == n
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] does not contain u.
 * All the values of graph[u] are unique.
 * If graph[u] contains v, then graph[v] contains u.
 * </pre>
 */
public class _785_Is_Graph_Bipartite extends LeetcodeProblemSolution {

    @Topic(TopicType.GRAPH)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public boolean isBipartite(int[][] graph) {
        // 染色法解决二分图问题，相邻节点颜色不同则结果正确
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            // 遍历每一个起点
            if (colors[i] == -1) {
                if (!bfs(i, colors, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int start, int[] colors, int[][] graph) {
        colors[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                if (colors[v] == -1) {
                    // 未染色部分进行染色
                    colors[v] = 1 - colors[u];
                    queue.offer(v);
                } else {
                    // 检查是否颜色相反
                    if (colors[v] == colors[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
