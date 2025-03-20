package io.hank.leetcode;

import io.hank.leetcode.practices.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Leetcode!");
        runHash();
        runTwoPointer();
        runSort();
        runGreedy();
        runBinarySearch();
        runRecursion();
        runSearch();
        runBacktrack();
        runDP();
        runLinkedList();
    }

    private static void runHash() {
        System.out.println("\n******** Hash *******");
        new _1_Two_Sum().execute();
        new _3_Longest_Substring_Without_Repeating().execute();
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

    private static void runRecursion() {
        System.out.println("\n******** Recursion *******");
        new _241_Different_Ways_Add_Parentheses().execute();
        new _95_Unique_Binary_Search_Trees_II().execute();
    }

    private static void runSearch() {
        System.out.println("\n******** Search *******");
        new _1091_Shortest_Path_in_Binary_Matrix().execute();
        new _279_Perfect_Squares().execute();
        new _127_Word_Ladder().execute();
        new _695_Max_Area_of_Island().execute();
        new _200_Number_of_Islands().execute();
        new _547_Number_of_Provinces().execute();
        new _130_Surrounded_Regions().execute();
        new _417_Pacific_Atlantic_Water_Flow().execute();
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
        new _5_Longest_Palindromic_Substring().execute();
        new _10_Regular_Expression_Matching().execute();
        new _70_Climbing_Stairs().execute();
        new _198_House_Robber().execute();
        new _64_Min_Path_Sum().execute();
        new _62_Unique_Paths().execute();
        new _303_Range_Sum_Query_Immutable().execute();
        new _413_Arithmetic_Slices().execute();
    }

    private static void runLinkedList() {
        new _2_Add_Two_Numbers().execute();
    }
}
