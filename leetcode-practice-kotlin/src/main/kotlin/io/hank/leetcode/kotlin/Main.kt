package io.hank.leetcode.kotlin

import io.hank.leetcode.kotlin.practices._001_Two_Sum
import io.hank.leetcode.kotlin.practices._002_Add_Two_Numbers
import io.hank.leetcode.kotlin.practices._003_Longest_Substring_Without_Repeating
import io.hank.leetcode.kotlin.practices._004_Median_of_Two_Sorted_Arrays

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello, Leetcode!")
        _001_Two_Sum().execute()
        _002_Add_Two_Numbers().execute()
        _003_Longest_Substring_Without_Repeating().execute()
        _004_Median_of_Two_Sorted_Arrays().execute()
    }
}
