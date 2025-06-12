from collections import deque

from libs.tree_node import TreeNode


class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
        ans = list()
        if root is None:
            return ans
        queue = deque()
        queue.append(root)
        while queue:
            cnt = len(queue)
            for i in range(cnt):
                cur = queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                if i == cnt - 1:
                    ans.append(cur.val)
        return ans


if __name__ == "__main__":
    s = Solution()
    rootNode = TreeNode(1)
    rootNode.left = TreeNode(2)
    rootNode.right = TreeNode(3)
    print(s.rightSideView(rootNode))
