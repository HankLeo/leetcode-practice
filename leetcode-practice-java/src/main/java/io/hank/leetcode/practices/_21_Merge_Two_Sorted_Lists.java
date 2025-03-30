package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * </pre>
 */
public class _21_Merge_Two_Sorted_Lists extends LeetcodeProblemSolution {

    @Topic({TopicType.LINKED_LIST, TopicType.TWO_POINTER})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            }
            if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                ListNode next = list1.next;
                list1.next = null;
                cur.next = list1;
                cur = cur.next;
                list1 = next;
            } else {
                ListNode next = list2.next;
                list2.next = null;
                cur.next = list2;
                cur = cur.next;
                list2 = next;
            }
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }
}
