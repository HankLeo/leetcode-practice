package io.hank.leetcode.practices.tree;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 * </pre>
 */
public class _208_Implement_Trie extends LeetcodeProblemSolution {

    @Topic({TopicType.TREE, TopicType.TRIE})
    public void implementTrie() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
    }

    @Override
    public void execute() {
        super.execute();
        implementTrie();
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChild(c)) {
                node.addChild(c);
            }
            node = node.getChild(c);
        }
        node.setLeaf(true);
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChild(c)) {
                return false;
            }
            node = node.getChild(c);
        }
        return node.isLeaf();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.containsChild(c)) {
                return false;
            }
            node = node.getChild(c);
        }
        return true;
    }

    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }

        public boolean containsChild(char c) {
            return children[c - 'a'] != null;
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }
    }
}
