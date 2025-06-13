# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: Node | None) -> Node | None:
        if not head:
            return None

        dic = {}
        cur = head
        while cur:
            dic[cur] = Node(cur.val)
            cur = cur.next

        cur = head
        while cur:
            dic[cur].next = dic.get(cur.next)  # 用get防止cur.next为None
            dic[cur].random = dic.get(cur.random)
            cur = cur.next
        return dic[head]


if __name__ == "__main__":
    solution = Solution()
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node1.random = node3
    print(solution.copyRandomList(node1))
