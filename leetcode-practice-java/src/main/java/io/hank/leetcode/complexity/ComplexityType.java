package io.hank.leetcode.complexity;

public enum ComplexityType {
    O_1("O(1)"),
    O_N("O(N)"),
    O_N2("O(N ^ 2)"),
    O_MN("O(M * N)"),
    O_LOG_M_DIVIDE_LOG_N("O(logM / logN)"),
    O_MIN_M_N("O(Min(M, N))"),
    O_LG_N("O(lg(N))");

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
