package io.hank.leetcode.annotations;

public enum TopicType {
    HASH("Hash"),
    MATH("Math"),
    TWO_POINTER("Two Pointer"),
    SORT_AND_SELECTION("Sort and Selection"),
    BINARY_SEARCH("Binary Search"),
    GREEDY("Greedy"),
    RECURSION("Recursion"),
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
