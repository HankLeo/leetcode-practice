package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10^5
 * 最多调用 2 * 10^5 次 get 和 put
 * </pre>
 */
public class _146_LRU_Cache extends LeetcodeProblemSolution {

    @Topic({TopicType.LINKED_LIST, TopicType.QUEUE, TopicType.HASH})
    public void LRUCache() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    static class LRUCache {
        Map<Integer, ListNode> cacheMap = new HashMap<>();
        int capacity;
        ListNode head;
        ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (cacheMap.containsKey(key)) {
                ListNode node = cacheMap.get(key);
                moveToHead(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                ListNode node = cacheMap.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                ListNode node = new ListNode(key, value);
                cacheMap.put(key, node);
                addFirst(node);
                if (cacheMap.size() > capacity) {
                    int removedKey = removeLast();
                    cacheMap.remove(removedKey);
                }
            }
        }

        private void moveToHead(ListNode node) {
            removeNode(node);
            addFirst(node);
        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

        }

        private void addFirst(ListNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private int removeLast() {
            ListNode removed = tail.prev;
            tail.prev = removed.prev;
            removed.prev.next = tail;
            return removed.key;
        }

        static class ListNode {
            int key;
            int val;
            ListNode prev;
            ListNode next;

            public ListNode() {
            }

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public ListNode(int key, int val, ListNode prev, ListNode next) {
                this.key = key;
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity + 1, 1, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
