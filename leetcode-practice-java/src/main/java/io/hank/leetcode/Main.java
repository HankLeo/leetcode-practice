package io.hank.leetcode;

import io.hank.leetcode.practices.arraymatrix.ArrayMatrixPractices;
import io.hank.leetcode.practices.backtrack.BackTrackPractices;
import io.hank.leetcode.practices.binarysearch.BinarySearchPractices;
import io.hank.leetcode.practices.dp.DpPractices;
import io.hank.leetcode.practices.graph.GraphPractices;
import io.hank.leetcode.practices.greedy.GreedyPractices;
import io.hank.leetcode.practices.hash.HashPractices;
import io.hank.leetcode.practices.linkedlist.LinkedListPractices;
import io.hank.leetcode.practices.math.MathPractices;
import io.hank.leetcode.practices.recursion.RecursionPractices;
import io.hank.leetcode.practices.search.SearchPractices;
import io.hank.leetcode.practices.slidingwindow.SlidingWindowPractices;
import io.hank.leetcode.practices.sort.SortPractices;
import io.hank.leetcode.practices.stackqueue.StackQueuePractices;
import io.hank.leetcode.practices.string.StringPractices;
import io.hank.leetcode.practices.tree.TreePractices;
import io.hank.leetcode.practices.twopointer.TwoPointerPractices;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Leetcode!");

        TwoPointerPractices.execute();
        SortPractices.execute();
        BinarySearchPractices.execute();
        GreedyPractices.execute();
        RecursionPractices.execute();
        SearchPractices.execute();
        BackTrackPractices.execute();
        DpPractices.execute();
        MathPractices.execute();
        LinkedListPractices.execute();
        TreePractices.execute();
        StackQueuePractices.execute();
        HashPractices.execute();
        StringPractices.execute();
        ArrayMatrixPractices.execute();
        GraphPractices.execute();
        SlidingWindowPractices.execute();
    }

}
