package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * </pre>
 */
public class _25_Reverse_Nodes_In_K_Group extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prev = hair;
        ListNode next = head;
        while (next != null) {
            ListNode start = next;
            ListNode end = next;
            for (int i = 1; i < k; i++) {
                if (end == null) {
                    break; // 不满k
                }
                end = end.next;
            }
            if (end == null) {
                break;  // 不满k
            }
            next = end.next;
            end.next = null;
            prev.next = reverse(start);
            prev = start;
            prev.next = next;
        }
        return hair.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode newHead = start;
        ListNode next = start.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = newHead;
            newHead = next;
            next = tmp;
        }
        return newHead;
    }
}
