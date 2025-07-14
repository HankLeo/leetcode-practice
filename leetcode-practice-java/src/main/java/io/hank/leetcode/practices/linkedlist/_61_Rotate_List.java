package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

public class _61_Rotate_List extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先计算链表长度，并找到最后一个node
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        // 再判断移动位置
        int newHeadIndex = len - k % len;
        if (newHeadIndex == 0) {
            return head;
        }
        cur.next = head; // 当前tail一定在当前head之前
        cur = head;
        ListNode ans = cur.next;
        // 最后移动到目标node
        for (int i = 0; i < newHeadIndex - 1; i++) {
            cur = cur.next;
            ans = ans.next;
        }
        cur.next = null;
        return ans;
    }
}
