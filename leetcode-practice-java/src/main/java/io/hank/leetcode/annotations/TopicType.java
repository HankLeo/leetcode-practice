package io.hank.leetcode.annotations;

public enum TopicType {
    HASH("Hash"),
    STRING("String"),
    SLIDING_WINDOW("Sliding Window"),
    ARRAY("Array"),
    MATRIX("Matrix"),
    LINKED_LIST("Linked List"),
    TREE("Tree"),
    BST("Binary Search Tree"),
    TRIE("Trie"),
    STACK("Stack"),
    QUEUE("Queue"),
    HEAP("Heap"),
    GRAPH("Graph"),

    MATH("Math"),
    PREFIX_SUM("Prefix Sum"),
    BIT_MANIPULATION("Bit Manipulation"),
    TWO_POINTER("Two Pointer"),
    SORT_AND_SELECTION("Sort and Selection"),
    BINARY_SEARCH("Binary Search"),
    GREEDY("Greedy"),
    RECURSION("Recursion"),
    DP("Dynamic Programming"),
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
