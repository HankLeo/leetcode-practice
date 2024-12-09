package io.hank.leetcode.kotlin.practices

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 *
 * Output: [7,0,8]
 *
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 *
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *
 * Output: [8,9,9,9,0,0,0,1]
 */
class _002_Add_Two_Numbers {

    class ListNode(val `val`: Int, var next: ListNode? = null)

    private fun addTwoNumbers(_l1: ListNode?, _l2: ListNode?): ListNode {
        var l1 = _l1
        var l2 = _l2

        val dummyHead = ListNode(0)
        var pointer = dummyHead
        var carry = 0

        while (l1 != null || l2 != null || carry != 0) {
            val digit1 = l1?.`val` ?: 0
            val digit2 = l2?.`val` ?: 0
            val sum = digit1 + digit2 + carry
            val digit = sum % 10
            carry = sum / 10

            pointer.next = ListNode(digit)
            pointer = pointer.next!!

            l1 = l1?.next
            l2 = l2?.next
        }

        return dummyHead.next!!.also {
            dummyHead.next = null
        }
    }

    private fun printResult(result: ListNode?) {
        var pointer = result
        val sb = StringBuilder()
        while (pointer != null) {
            sb.append(pointer.`val`)
            pointer = pointer.next
        }
        println(sb.toString())
    }

    fun execute() {
        // Example 1
        val l1 = ListNode(2, ListNode(4, ListNode(3)))
        val l2 = ListNode(5, ListNode(6, ListNode(4)))

        println(printResult(addTwoNumbers(l1, l2)))
    }
}