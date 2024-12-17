package io.hank.leetcode.annotations;

public enum ComplexityType {
    O_N("O(N)"),
    O_1("O(1)"),
    O_LOG_M_DIVIDE_LOG_N("O(logM/logN)");

    private final String value;

    ComplexityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
