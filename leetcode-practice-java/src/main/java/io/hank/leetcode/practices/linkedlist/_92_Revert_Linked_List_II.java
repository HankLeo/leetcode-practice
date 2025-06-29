package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * </pre>
 */
public class _92_Revert_Linked_List_II extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        // 找到反转前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找到反转后一个节点
        ListNode end = pre;
        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }
        ListNode after = end.next;
        // 截断反转部分
        ListNode start = pre.next;
        pre.next = null;
        end.next = null;
        reverseLinkedList(start);
        pre.next = end;
        start.next = after;
        ListNode res = dummy.next;
        dummy.next = null;
        return res;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
