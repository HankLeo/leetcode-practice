from libs.list_node import ListNode


class Solution:
    def merge_two_lists(self, list1: [ListNode], list2: [ListNode]) -> [ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        p1, p2 = list1, list2
        dummy = ListNode()
        cur = dummy
        while p1 and p2:
            if p1.val < p2.val:
                cur.next = p1
                p1 = p1.next
            else:
                cur.next = p2
                p2 = p2.next
            cur = cur.next
        if p1:
            cur.next = p1
        if p2:
            cur.next = p2
        return dummy.next
