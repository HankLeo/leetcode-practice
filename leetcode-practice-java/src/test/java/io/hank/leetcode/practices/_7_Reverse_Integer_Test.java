package io.hank.leetcode.practices;

import io.hank.leetcode.practices.math._7_Reverse_Integer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _7_Reverse_Integer_Test {

    private final _7_Reverse_Integer solution = new _7_Reverse_Integer();

    @Test
    void testReverse_PositiveNumber() {
        assertEquals(321, solution.reverse(123));
    }

    @Test
    void testReverse_NegativeNumber() {
        assertEquals(-321, solution.reverse(-123));
    }

    @Test
    void testReverse_Zero() {
        assertEquals(0, solution.reverse(0));
    }

    @Test
    void testReverse_PositiveOverflow() {
        assertEquals(0, solution.reverse(2147483647)); // Exceeds Integer.MAX_VALUE after reversal
    }

    @Test
    void testReverse_NegativeOverflow() {
        assertEquals(0, solution.reverse(-2147483648)); // Exceeds Integer.MIN_VALUE after reversal
    }

    @Test
    void testReverse_TrailingZeros() {
        assertEquals(21, solution.reverse(120));
    }

    @Test
    void testReverse_SingleDigit() {
        assertEquals(7, solution.reverse(7));
    }
}
