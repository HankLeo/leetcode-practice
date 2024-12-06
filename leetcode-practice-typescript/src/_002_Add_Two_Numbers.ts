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

class ListNode {
  val: number
  next: ListNode | null

  constructor(val: number, next?: ListNode | null) {
    this.val = val
    this.next = next || null
  }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  const dummyHead = new ListNode(0)
  let pointer = dummyHead
  let carry = 0

  while (l1 != null || l2 != null || carry != 0) {
    const digit1: number = l1?.val || 0
    const digit2: number = l2?.val || 0
    const sum = digit1 + digit2 + carry
    const digit = sum % 10
    carry = sum >= 10 ? 1 : 0

    pointer.next = new ListNode(digit)
    pointer = pointer.next

    l1 = l1?.next || null
    l2 = l2?.next || null
  }

  const result = dummyHead.next
  dummyHead.next = null
  return result
}

function printOutput(result: ListNode | null) {
  let output: string = ''
  while (result != null) {
    output += result.val
    result = result.next || null
  }
  console.log(output)
}

export function execute() {
  let pointer: ListNode
  // Example 1
  let l1 = new ListNode(2)
  pointer = l1.next = new ListNode(4)
  pointer.next = new ListNode(3)

  let l2 = new ListNode(5)
  pointer = l2.next = new ListNode(6)
  pointer.next = new ListNode(4)

  printOutput(addTwoNumbers(l1, l2))

}
