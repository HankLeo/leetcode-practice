package io.hank.leetcode;

import io.hank.leetcode.practices.*;
import io.hank.leetcode.practices.binarysearch.BinarySearchPractices;
import io.hank.leetcode.practices.greedy.GreedyPractices;
import io.hank.leetcode.practices.hash.HashPractices;
import io.hank.leetcode.practices.linkedlist.LinkedListPractices;
import io.hank.leetcode.practices.math.MathPractices;
import io.hank.leetcode.practices.recursion.RecursionPractices;
import io.hank.leetcode.practices.search.SearchPractices;
import io.hank.leetcode.practices.sort.SortPractices;
import io.hank.leetcode.practices.string.StringPractices;
import io.hank.leetcode.practices.tree.TreePractices;
import io.hank.leetcode.practices.twopointer.TwoPointerPractices;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Leetcode!");
        HashPractices.execute();
        StringPractices.execute();
        TwoPointerPractices.execute();
        SortPractices.execute();
        BinarySearchPractices.execute();
        GreedyPractices.execute();
        RecursionPractices.execute();
        SearchPractices.execute();
        runBacktrack();
        runDP();
        MathPractices.execute();
        LinkedListPractices.execute();
        TreePractices.execute();
    }

    private static void runBacktrack() {
        System.out.println("\n******** Backtrack *******");
        new _17_Letter_Combinations_of_Phone_Number().execute();
        new _93_Restore_IP_Addresses().execute();
        new _79_Word_Search().execute();
        new _257_Binary_Tree_Paths().execute();
        new _46_Permutations().execute();
        new _47_Permutations_II().execute();
        new _77_Combinations().execute();
        new _39_Combination_Sum().execute();
        new _40_Combination_Sum_II().execute();
        new _216_Combination_Sum_III().execute();
        new _78_Subsets().execute();
        new _90_Subsets_II().execute();
        new _131_Palindrome_Partitioning().execute();
        new _37_Sudoku_Solver().execute();
        new _51_N_Queens().execute();
    }

    private static void runDP() {
        System.out.println("\n******** DP *******");
        new _5_Longest_Palindromic_Substring().execute();
        new _10_Regular_Expression_Matching().execute();
        new _70_Climbing_Stairs().execute();
        new _198_House_Robber().execute();
        new _64_Min_Path_Sum().execute();
        new _62_Unique_Paths().execute();
        new _303_Range_Sum_Query_Immutable().execute();
        new _413_Arithmetic_Slices().execute();
        new _91_Decode_Ways().execute();
        new _300_Longest_Increasing_Subsequence().execute();
        new _376_Wiggle_Subsequence().execute();
        new _1143_Longest_Common_Subsequence().execute();
        new _583_Delete_Operation_for_Two_Strings().execute();
        new _72_Edit_Distance().execute();
        // stock buy and sell
        new _309_Buy_Sell_Stock_with_Cooldown().execute();
        new _714_Buy_Sell_Stock_with_Fee().execute();
        new _123_Best_Buy_Sell_Stock_with_2_Times().execute();
        new _188_Best_Buy_Sell_Stock_with_K_Times().execute();
        // 0-1 knapsack
        new _416_Partition_Equal_Subset_Sum().execute();
        new _494_Target_Sum().execute();
        new _474_Ones_and_Zeroes().execute();
        new _322_Coin_Change().execute();
        new _518_Coin_Change_II().execute();
        new _139_Word_Break().execute();
        new _377_Combination_Sum_IV().execute();
    }

}
