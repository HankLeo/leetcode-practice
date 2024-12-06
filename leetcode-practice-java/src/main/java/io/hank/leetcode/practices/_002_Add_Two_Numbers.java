package io.hank.leetcode.practices;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * <p>
 * Output: [7,0,8]
 * <p>
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * <p>
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <p>
 * Output: [8,9,9,9,0,0,0,1]
 */
public class _002_Add_Two_Numbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            ListNode newNode = new ListNode(digit);
            pointer.next = newNode;
            pointer = pointer.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    void printerResult(ListNode result) {
        StringBuilder output = new StringBuilder();
        while (result != null) {
            output.append(result.val);
            result = result.next;
        }
        System.out.println(output.toString());
    }

    public void execute() {
        ListNode pointer;
        // Example 1
        ListNode l1 = new ListNode(2);
        pointer = l1.next = new ListNode(4);
        pointer.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        pointer = l2.next = new ListNode(6);
        pointer.next = new ListNode(4);

        printerResult(addTwoNumbers(l1, l2));
        
    }

}