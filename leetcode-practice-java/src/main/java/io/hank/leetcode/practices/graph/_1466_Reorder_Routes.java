package io.hank.leetcode.practices.graph;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 *
 * 示例 2：
 *
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 *
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * </pre>
 */
public class _1466_Reorder_Routes extends LeetcodeProblemSolution {

    @Topic({TopicType.GRAPH, TopicType.BFS})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int minReorderBfs(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);

        // bfs
        Queue<List<int[]>> queue = new LinkedList<>();
        queue.offer(graph[0]);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            List<int[]> nextCities = queue.poll();
            for (int[] cityWithW : nextCities) {
                int city = cityWithW[0], w = cityWithW[1];
                if (!visited[city]) {
                    res += w;
                    visited[city] = true;
                    queue.offer(graph[city]);
                }
            }
        }
        return res;
    }

    @Topic({TopicType.GRAPH, TopicType.DFS})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public int minReorderDfs(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        return dfs(graph, 0, -1);
    }

    private int dfs(List<int[]>[] graph, int cur, int from) {
        int res = 0;
        List<int[]> nextCities = graph[cur];
        for (int[] cityAndW : nextCities) {
            int city = cityAndW[0], w = cityAndW[1];
            if (city != from) {
                // 单向遍历
                res += w + dfs(graph, city, cur);
            }
        }
        return res;
    }

    // 把树变成带权无向图，起点就是目的地0，每条边的权就是方向
    // 正向权值为1，表示需要反转，逆向则权值为0
    // 下标i表示第i个城市有几个相邻城市
    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            graph[u].add(new int[]{v, 1}); // 正向
            graph[v].add(new int[]{u, 0}); // 逆向
        }

        return graph;
    }
}
