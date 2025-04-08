package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Design a map that allows you to do the following:
 *
 * Maps a string key to a given value.
 * Returns the sum of the values that have a key with a prefix equal to a given string.
 * Implement the MapSum class:
 *
 * MapSum() Initializes the MapSum object.
 * void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
 * int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 *
 *
 * Example 1:
 *
 * Input
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * Output
 * [null, null, 3, null, 5]
 *
 * Explanation
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * Constraints:
 *
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 * 1 <= val <= 1000
 * At most 50 calls will be made to insert and sum.
 * </pre>
 */
public class _677_Map_Sum_Pairs extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.TRIE})
    public void mapSumPairs() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }

    @Override
    public void execute() {
        super.execute();
        mapSumPairs();
    }
}

class MapSum {
    private final TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.containsChild(c)) {
                cur.addChild(c);
            }
            cur = cur.getChild(c);
        }
        cur.setValue(val);
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.containsChild(c)) {
                return 0;
            }
            cur = cur.getChild(c);
        }
        int sum = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            sum += node.getValue();
            for (char c = 'a'; c <= 'z'; c++) {
                if (node.containsChild(c)) {
                    queue.offer(node.getChild(c));
                }
            }
        }
        return sum;
    }

    private static class TrieNode {
        private final TrieNode[] children;
        private int val;

        public TrieNode() {
            children = new TrieNode[26];
            val = 0;
        }

        public int getValue() {
            return val;
        }

        public void setValue(int val) {
            this.val = val;
        }

        public boolean containsChild(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }
    }
}