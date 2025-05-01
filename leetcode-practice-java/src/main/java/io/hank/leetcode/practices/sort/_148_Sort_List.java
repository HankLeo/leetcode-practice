package io.hank.leetcode.practices.sort;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 *
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * </pre>
 */
public class _148_Sort_List extends LeetcodeProblemSolution {

    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N_LOG_N)
    @SpaceComplexity(ComplexityType.O_N)
    public ListNode sortList(ListNode head) {
        // 递归终止
        if (head == null || head.next == null) {
            return head;
        }
        // 归并排序
        // 拆分
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);
        // 合并
        ListNode cur = new ListNode();
        ListNode res = cur;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return res.next;
    }
}
