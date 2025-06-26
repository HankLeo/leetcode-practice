import {ListNode} from "../libs";

function hasCycle(head: ListNode | null): boolean {
    if (head === null) {
        return false;
    }
    if (head.next === null) {
        return false;
    }

    let slow: ListNode | null = head;
    let fast: ListNode | null = head.next;
    while (slow !== null && fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}

console.log(hasCycle(new ListNode(3)))
console.log(hasCycle(new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))))))
