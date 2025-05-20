import {ListNode} from '../libs';

function oddEvenList(head: ListNode | null): ListNode | null {
    if (head == null) {
        return head;
    }
    let curOdd = head;
    let curEven = head.next;
    const evenHead = curEven;
    while (curOdd != null && curEven != null) {
        const nextOdd = curEven.next;
        if (nextOdd == null) {
            break;
        } else {
            const nextEven = nextOdd.next;
            curOdd.next = nextOdd;
            curEven.next = nextEven;
            curOdd = nextOdd;
            curEven = nextEven;
        }
    }
    curOdd.next = evenHead;
    return head;
}

console.log(
    oddEvenList(
        new ListNode(
            1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))),
        ),
    ),
);
