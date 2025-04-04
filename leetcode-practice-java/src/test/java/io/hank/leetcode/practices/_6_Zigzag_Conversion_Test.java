package io.hank.leetcode.practices;

import io.hank.leetcode.practices.string._6_Zigzag_Conversion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _6_Zigzag_Conversion_Test {
    private static _6_Zigzag_Conversion solution;

    @BeforeAll
    static void setup() {
        solution = new _6_Zigzag_Conversion();
    }

    @ParameterizedTest
    @CsvSource({
            "'PAYPALISHIRING', 3, 'PAHNAPLSIIGYIR'",
            "'PAYPALISHIRING', 4, 'PINALSIGYAHRPI'",
            "'PAYPALISHIRING', 1, 'PAYPALISHIRING'",
            "'HELLO', 2, 'HLOEL'",
            "'', 3, ''",
            "'A', 3, 'A'"
    })
    void testConvert(String input, int numRows, String expected) {
        assertEquals(expected, solution.convert(input, numRows));
    }
}
