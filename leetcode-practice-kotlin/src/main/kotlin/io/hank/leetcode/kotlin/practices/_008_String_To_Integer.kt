package io.hank.leetcode.kotlin.practices

class _008_String_To_Integer : LeetcodeProblemSolution() {
    fun myAtoi(s: String): Int {
        s.trim().also {
            if (it.isEmpty()) return 0

            var input = it
            var result = 0
            val isNegative: Boolean = when (input[0]) {
                '+' -> {
                    input = input.substring(1 until input.length)
                    false
                }

                '-' -> {
                    input = input.substring(1 until input.length)
                    true
                }

                else -> false
            }

            run loop@{
                input.forEach { c ->
                    (c - '0').takeIf { num -> num in 0..9 }?.let { num ->
                        if (result > (Integer.MAX_VALUE - num) / 10) {
                            return if (isNegative) Integer.MIN_VALUE else Integer.MAX_VALUE
                        }
                        result = 10 * result + num
                    } ?: return@loop
                }
            }

            return if (isNegative) -result else result
        }

    }

    override fun execute() {
        super.execute()

        // Example 1
        var s = "    -42"
        println("Input: s=${s}")
        println("Output: ${myAtoi(s)}")
    }
}
