from libs.tree_node import TreeNode


class Solution:
    def isSymmetric(self, root: TreeNode | None) -> bool:
        if not root:
            return True

        def dfs(left_node, right_node):
            if left_node and right_node:
                return left_node.val == right_node.val and dfs(left_node.left, right_node.right) and dfs(
                    right_node.left, left_node.right)
            elif not left_node and not right_node:
                return True
            else:
                return False

        return dfs(root.left, root.right)
