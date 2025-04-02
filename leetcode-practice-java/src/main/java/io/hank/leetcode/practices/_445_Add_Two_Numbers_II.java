package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.LinkedList;

public class _445_Add_Two_Numbers_II extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = buildStack(l1);
        LinkedList<Integer> list2 = buildStack(l2);
        int carry = 0;
        ListNode head = new ListNode();
        while (!list1.isEmpty() || !list2.isEmpty() || carry != 0) {
            int val1 = list1.isEmpty() ? 0 : list1.pop();
            int val2 = list2.isEmpty() ? 0 : list2.pop();
            int newVal = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode node = new ListNode(newVal);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    private LinkedList<Integer> buildStack(ListNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        while (node != null) {
            list.push(node.val);
            node = node.next;
        }
        return list;
    }
}
