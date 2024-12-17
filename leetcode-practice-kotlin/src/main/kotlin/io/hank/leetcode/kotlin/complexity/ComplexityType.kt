package io.hank.leetcode.kotlin.complexity

enum class ComplexityType(val value: String) {
    O_N("O(N)"),
    O_1("O(1)"),
    O_LOG_M_DIVIDE_LOG_N("O(logM/logN)");

    override fun toString() = value
}