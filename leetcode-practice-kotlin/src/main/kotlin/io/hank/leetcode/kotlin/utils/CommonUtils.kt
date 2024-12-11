package io.hank.leetcode.kotlin.utils

object CommonUtils {
    fun <T: Any> printProblemName(obj: T) {
        println("==== Problem: ${obj::class.simpleName} ====")
    }
}