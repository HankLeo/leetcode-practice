import {ListNode} from "../libs";

function reverseList(head: ListNode | null): ListNode | null {
    if (!head || !head.next) {
        return head;
    }
    const reverseNext = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reverseNext;
}

const head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
console.log(reverseList(head));
