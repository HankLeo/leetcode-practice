package io.hank.leetcode.practices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _008_String_To_Integer_Test {

    private final _008_String_To_Integer solution = new _008_String_To_Integer();

    @Test
    void testValidPositiveNumber() {
        assertEquals(123, solution.myAtoi("123"));
    }

    @Test
    void testValidNegativeNumber() {
        assertEquals(-123, solution.myAtoi("-123"));
    }

    @Test
    void testValidNumberWithSpaces() {
        assertEquals(42, solution.myAtoi("   42"));
    }

    @Test
    void testValidNumberWithLeadingPlus() {
        assertEquals(42, solution.myAtoi("+42"));
    }

    @Test
    void testInvalidNumberWithCharacters() {
        assertEquals(42, solution.myAtoi("42abc"));
    }

    @Test
    void testInvalidNumberWithSpacesAfterNumber() {
        assertEquals(42, solution.myAtoi("42 abc"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, solution.myAtoi(""));
    }

    @Test
    void testStringWithOnlySpaces() {
        assertEquals(0, solution.myAtoi("   "));
    }

    @Test
    void testNumberExceedsIntegerMax() {
        assertEquals(Integer.MAX_VALUE, solution.myAtoi("2147483648"));
    }

    @Test
    void testNumberBelowIntegerMin() {
        assertEquals(Integer.MIN_VALUE, solution.myAtoi("-2147483649"));
    }

    @Test
    void testNumberWithLeadingZeroes() {
        assertEquals(42, solution.myAtoi("00042"));
    }

    @Test
    void testStringWithOnlyPlusSign() {
        assertEquals(0, solution.myAtoi("+"));
    }

    @Test
    void testStringWithOnlyMinusSign() {
        assertEquals(0, solution.myAtoi("-"));
    }
}

