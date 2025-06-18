from collections import deque

from libs.tree_node import TreeNode


class Solution:
    def average_of_levels(self, root: TreeNode) -> list[float]:
        ans = list()
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            sum_of_row = 0
            for i in range(size):
                node = queue.popleft()
                sum_of_row += node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(sum_of_row / size)
        return ans


if __name__ == '__main__':
    s = Solution()
    rootNode = TreeNode(3)
    rootNode.left = TreeNode(9)
    rootNode.right = TreeNode(20)
    rootNode.right.left = TreeNode(15)
    rootNode.right.right = TreeNode(7)
    print(s.average_of_levels(rootNode))
