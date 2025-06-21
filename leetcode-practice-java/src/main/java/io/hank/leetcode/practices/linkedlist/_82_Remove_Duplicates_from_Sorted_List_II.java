package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * </pre>
 */
public class _82_Remove_Duplicates_from_Sorted_List_II extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int dupVal = cur.next.val;
                while (cur.next != null && cur.next.val == dupVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
