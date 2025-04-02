package io.hank.leetcode.annotations;

public enum TopicType {
    STRING("String"),
    LINKED_LIST("Linked List"),
    TREE("Tree"),

    HASH("Hash"),
    MATH("Math"),
    TWO_POINTER("Two Pointer"),
    SORT_AND_SELECTION("Sort and Selection"),
    BINARY_SEARCH("Binary Search"),
    GREEDY("Greedy"),
    RECURSION("Recursion"),
    DP("Dynamic Programming"),
    MATRIX("Matrix"),
    BFS("Breadth-First Search"),
    DFS("Depth-First Search"),
    BACKTRACK("Backtrack"),
    ;

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
