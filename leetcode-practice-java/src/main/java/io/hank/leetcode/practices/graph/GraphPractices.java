package io.hank.leetcode.practices.graph;

public class GraphPractices {
    public static void execute() {
        System.out.println("\n******** Graph ********");
        new _207_Course_Schedule().execute();
        new _785_Is_Graph_Bipartite().execute();
        new _994_Rotting_Oranges().execute();
        // BFS
        new _1926_Nearest_Exit_From_Entrance_in_Maze().execute();
        new _1466_Reorder_Routes().execute();
        new _399_Evaluate_Division().execute();
        new _909_Snakes_and_Ladders().execute();
        // DFS
        new _841_Keys_and_Rooms().execute();
    }

    public static void main(String[] args) {
        execute();
    }
}
