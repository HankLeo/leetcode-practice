package io.hank.leetcode.practices.graph;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.*;

/**
 * <pre>
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 *
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 *
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * </pre>
 */
public class _399_Evaluate_Division extends LeetcodeProblemSolution {

    static class TargetPoint {
        String target;
        double weight;

        public TargetPoint(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    @Topic({TopicType.GRAPH, TopicType.BFS})
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建有向带权图
        Map<String, List<TargetPoint>> graph = buildGraph(equations, values);

        // queries决定起点和终点
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // 过滤不存在的点
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(target)) {
                res[i] = -1.0;
                continue;
            }
            // 如果start和target相同
            if (start.equals(target)) {
                res[i] = 1.0;
                continue;
            }
            // bfs查找结果
            Queue<TargetPoint> queue = new LinkedList<>();
            queue.offer(new TargetPoint(start, 1.0));
            // 记录遍历过的点（图存在环）
            Set<String> set = new HashSet<>();
            set.add(start);
            boolean found = false;
            while (!queue.isEmpty()) {
                TargetPoint curPoint = queue.poll();
                String cur = curPoint.target;
                double curW = curPoint.weight;

                List<TargetPoint> nexts = graph.get(cur);
                for (TargetPoint nextPoint : nexts) {
                    String next = nextPoint.target;
                    double nextW = nextPoint.weight;
                    if (set.contains(next)) {
                        // 是环
                        continue;
                    }
                    double w = curW * nextW;
                    if (next.equals(target)) {
                        // 找到答案
                        res[i] = w;
                        found = true;
                        break;
                    }
                    queue.offer(new TargetPoint(next, w));
                    set.add(next);
                }
                if (found) {
                    break;
                }
            }
            // 找不到答案
            if (!found) {
                res[i] = -1.0;
            }
        }

        return res;
    }

    private Map<String, List<TargetPoint>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<TargetPoint>> graph = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String start = equations.get(i).get(0);
            String target = equations.get(i).get(1);
            double weight = values[i];
            // 除以
            List<TargetPoint> list = graph.getOrDefault(start, new ArrayList<>());
            list.add(new TargetPoint(target, weight));
            graph.put(start, list);
            // 被除
            list = graph.getOrDefault(target, new ArrayList<>());
            list.add(new TargetPoint(start, 1.0 / weight));
            graph.put(target, list);
        }
        return graph;
    }
}
