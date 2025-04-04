package io.hank.leetcode;

import io.hank.leetcode.practices.*;
import io.hank.leetcode.practices.hash.HashPractices;
import io.hank.leetcode.practices.linkedlist.LinkedListPractices;
import io.hank.leetcode.practices.recursion.RecursionPractices;
import io.hank.leetcode.practices.search.SearchPractices;
import io.hank.leetcode.practices.string.StringPractices;
import io.hank.leetcode.practices.tree.TreePractices;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Leetcode!");
        HashPractices.execute();
        StringPractices.execute();
        runTwoPointer();
        runSort();
        runGreedy();
        runBinarySearch();
        RecursionPractices.execute();
        SearchPractices.execute();
        runBacktrack();
        runDP();
        runMath();
        LinkedListPractices.execute();
        TreePractices.execute();
    }

    private static void runTwoPointer() {
        System.out.println("\n******** Two Pointer *******");
        new _167_Two_Sum_II_SortedArray().execute();
        new _633_Sum_of_Square_Numbers().execute();
        new _345_Reverse_Vowels_of_String().execute();
        new _680_Valid_Palindrome_II().execute();
        new _88_Merge_Sorted_Array().execute();
        new _141_Linked_List_Cycle().execute();
        new _524_Longest_Word_in_Dictionary_through_Deleting().execute();
        new _15_3Sum().execute();
        new _16_3Sum_Closest().execute();
        new _11_Container_With_Most_Water().execute();
    }

    private static void runSort() {
        System.out.println("\n******** Sort *******");
        new _215_Kth_Largest_Element_in_Array().execute();
        new _347_TopK_Frequent_Elements().execute();
        new _451_Sort_Characters_By_Frequency().execute();
        new _75_Sort_Colors().execute();
    }

    private static void runGreedy() {
        System.out.println("\n******** Greedy *******");
        new _455_Assign_Cookies().execute();
        new _435_Nonoverlapping_Intervals().execute();
        new _452_Min_Arrows_to_Burst_Balloons().execute();
        new _406_Queue_Reconstruction_by_Height().execute();
        new _121_Best_Time_to_Buy_and_Sell_Stock().execute();
        new _122_Best_Time_to_Buy_and_Sell_Stock_II().execute();
        new _605_Can_Place_Flowers().execute();
        new _392_Is_Subsequence().execute();
        new _665_Non_decreasing_Array().execute();
        new _53_Maximum_Subarray().execute();
        new _763_Partition_Labels().execute();
        new _646_Max_Pair_Chain_Length().execute();
    }

    private static void runBinarySearch() {
        System.out.println("\n******** Binary Search *******");
        new _69_Sqrt_X().execute();
        new _744_Find_Smallest_Letter_GT_Target().execute();
        new _540_Single_Element_in_Sorted_Array().execute();
        new _278_First_Bad_Version().execute();
        new _34_Find_First_Last_Element_in_Sorted_Array().execute();
        new _4_Median_of_Two_Sorted_Arrays().execute();
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

    private static void runMath() {
        System.out.println("\n******** Math *******");
        new _343_Integer_Break().execute();
        new _650_2_Keys_Keyboard().execute();
        new _7_Reverse_Integer().execute();
        new _9_Palindrome_Number().execute();
    }

}
