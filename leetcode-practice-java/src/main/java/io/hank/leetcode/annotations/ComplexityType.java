package io.hank.leetcode.annotations;

public enum ComplexityType {
    O_1("O(1)"),
    O_N("O(N)"),
    O_K("O(K)"),
    O_N2("O(N^2)"),
    O_SqrtN("O(Sqrt(N))"),
    O_NSqrtN("O(N^Sqrt(N))"),
    O_MN("O(MN)"),
    O_KN("O(KN)"),
    O_LOG_M_DIVIDE_LOG_N("O(logM/logN)"),
    O_M_PLUS_N("O(M+N)"),
    O_MIN_M_N("O(Min(M,N))"),
    O_LOG_N("O(log(N))"),
    O_N_LOG_N("O(N*logN)"),
    O_N_LOG_K("O(N*logK)"),
    O_2N("O(2^N)"),
    O_3N("O(3^N)");

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
