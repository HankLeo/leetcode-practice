package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * </pre>
 */
public class _206_Reverse_LinkedList extends LeetcodeProblemSolution {

    @Topic({TopicType.LINKED_LIST, TopicType.TWO_POINTER})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode reverseListByLoop(ListNode head) {
        ListNode result = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = result.next;
            result.next = head;
            head = next;
        }
        return result.next;
    }

    @Topic({TopicType.LINKED_LIST, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
