package io.hank.leetcode.annotations;

public enum TopicType {
    HASH("Hash"),
    TWO_POINTER("Two Pointer"),
    SORT_AND_SELECTION("Sort and Selection"),
    GREEDY("Greedy"),
    DP("Dynamic Programming");

    private final String name;

    TopicType(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
