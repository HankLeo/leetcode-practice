package io.hank.leetcode.kotlin.practices

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 *
 * A P L S I I G
 *
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 *
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 *
 * Output: "PINALSIGYAHRPI"
 *
 * Explanation:
 *
 * P     I    N
 *
 * A   L S  I G
 *
 * Y A   H R
 *
 * P     I
 *
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 *
 * Output: "A"
 */
class _006_Zigzag_Conversion : LeetcodeProblemSolution() {
    fun convert(s: String, numRows: Int): String {
        if (numRows < 2) {
            return s
        }

        val strLen = s.length
        val sbArray = Array(minOf(strLen, numRows)) { StringBuilder() }

        var i = 0
        while (i < strLen) {
            for (row in 0 until numRows) {
                takeIf { i < strLen }?.let { sbArray[row].append(s[i++]) }
            }
            for (row in numRows - 2 downTo 1) {
                takeIf { i < strLen }?.let { sbArray[row].append(s[i++]) }
            }
        }

        return StringBuilder().apply {
            sbArray.forEach { this.append(it) }
        }.toString()
    }
}
