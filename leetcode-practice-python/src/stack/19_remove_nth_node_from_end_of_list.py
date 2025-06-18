from libs.list_node import ListNode


class Solution:
    def remove_nth_from_end(self, head: ListNode, n: int) -> ListNode | None:
        # n最大是链表的长度
        # 也就有可能删除的是头节点，所以增加一个dummy head
        dummy_head = ListNode(0, head)
        stack = list()
        cur = dummy_head
        while cur:
            stack.append(cur)
            cur = cur.next

        for i in range(n):
            stack.pop()

        prev = stack[-1]
        prev.next = prev.next.next
        return dummy_head.next


if __name__ == '__main__':
    s = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(s.remove_nth_from_end(head, 2))
