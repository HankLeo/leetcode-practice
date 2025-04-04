package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 *
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 *
 * Output: [1]
 *
 * Example 4:
 *
 * Input: head = [1,2,3]
 *
 * Output: [2,1,3]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * </pre>
 */
public class _24_Swap_Nodes_in_Pairs extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        while (pre.next != null && pre.next.next != null) {
            ListNode left = pre.next;
            ListNode right = left.next;
            ListNode next = right.next;
            pre.next = right;
            right.next = left;
            left.next = next;
            pre = left;
        }
        return result.next;
    }
}
