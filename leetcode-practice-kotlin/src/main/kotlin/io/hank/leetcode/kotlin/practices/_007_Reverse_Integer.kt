package io.hank.leetcode.kotlin.practices

class _007_Reverse_Integer : LeetcodeProblemSolution() {
    fun reverse(x: Int): Int {
        return if (x == 0) 0 else run {
            val isNegative = x < 0
            var input = if (isNegative) -x else x

            var result = 0
            while (input > 0) {
                val mod = input % 10
                input /= 10
                if (result > (Integer.MAX_VALUE - mod) / 10) {
                    return 0
                }
                result = 10 * result + mod
            }
            return if (isNegative) -result else result
        }
    }
}
