package io.hank.leetcode;

import io.hank.leetcode.practices.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Leetcode!");

        LeetcodeProblemSolution solution;

        solution = new _001_Two_Sum();
        solution.execute();

        solution = new _002_Add_Two_Numbers();
        solution.execute();

        new _003_Longest_Substring_Without_Repeating().execute();
        new _004_Median_of_Two_Sorted_Arrays().execute();
        new _005_Longest_Palindromic_Substring().execute();
    }
}
