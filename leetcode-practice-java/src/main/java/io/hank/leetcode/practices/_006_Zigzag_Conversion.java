package io.hank.leetcode.practices;

import java.util.Arrays;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <br>
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * <br>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * <br>
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * <br>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * <br>
 * Output: "PINALSIGYAHRPI"
 * <p>
 * Explanation:
 * <pre>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 * Example 3:
 * <br>
 * Input: s = "A", numRows = 1
 * <br>
 * Output: "A"
 */
public class _006_Zigzag_Conversion extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_MIN_M_N)
    String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int n = s.length();
        StringBuilder[] sbArray = new StringBuilder[Math.min(numRows, n)];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }

        int i = 0;

        while (i < n) {
            for (int row = 0; row < numRows && i < n; row++) {
                sbArray[row].append(s.charAt(i++));
            }
            for (int row = numRows - 2; row > 0 && i < n; row--) {
                sbArray[row].append(s.charAt(i++));
            }
        }

        StringBuilder result = new StringBuilder();
        Arrays.stream(sbArray).forEach(sb -> {
            result.append(sb.toString());
        });
        return result.toString();
    }
}
