package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

public class _234_Palindrome_Linked_List extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode reverseHead = null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            ListNode tmp = new ListNode(cur.val);
            tmp.next = reverseHead;
            reverseHead = tmp;
            cur = cur.next;
        }
        for (int i = 0; i < len / 2; i++) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    @Override
    public void execute() {
        super.execute();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
}
