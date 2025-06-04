package io.hank.leetcode.practices.linkedlist;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.model.ListNode;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

public class _2130_Max_Twin_Sum_of_Linked_List extends LeetcodeProblemSolution {

    @Topic(TopicType.LINKED_LIST)
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时slow为右半部分第一个节点
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        ListNode left = head;
        while (slow != null) {
            leftList.add(left.val);
            rightList.add(slow.val);
            left = left.next;
            slow = slow.next;
        }
        // 求和，但要反着计算右边
        int n = leftList.size();
        int i = 0, j = n - 1;
        int maxVal = Integer.MIN_VALUE;
        while (i < n) {
            maxVal = Math.max(maxVal, leftList.get(i++) + rightList.get(j--));
        }
        return maxVal;
    }
}
