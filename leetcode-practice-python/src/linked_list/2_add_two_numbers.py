from libs.list_node import ListNode


class Solution:
    def add_two_numbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur = dummy = ListNode()
        carry = 0
        while l1 or l2 or carry:
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2.next
            cur.next = ListNode(carry % 10)
            carry //= 10
            cur = cur.next
        return dummy.next


if __name__ == "__main__":
    sol = Solution()
    print(sol.add_two_numbers(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4)))))
    print(sol.add_two_numbers(ListNode(0), ListNode(0)))
