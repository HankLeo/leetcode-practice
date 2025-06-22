from libs.tree_node import TreeNode


class Solution:
    def build_tree(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        # do partition for inorder according to preorder
        inorder_value_index = {value: index for index, value in enumerate(inorder)}

        def m_build_tree(preorder_start: int, preorder_end: int, inorder_start: int,
                         inorder_end: int) -> TreeNode | None:
            if preorder_start > preorder_end:
                return None
            # find root node in preorder
            root_value = preorder[preorder_start]
            # find partition in inorder
            inorder_root_index = inorder_value_index[root_value]
            # build root node
            root_node = TreeNode(root_value)
            # left subtree
            root_node.left = m_build_tree(preorder_start + 1, preorder_start + inorder_root_index - inorder_start,
                                          inorder_start, inorder_root_index - 1)
            # right subtree
            root_node.right = m_build_tree(preorder_start + inorder_root_index - inorder_start + 1, preorder_end,
                                           inorder_root_index + 1, inorder_end)
            return root_node

        end = len(preorder) - 1
        return m_build_tree(0, end, 0, end)


if __name__ == '__main__':
    s = Solution()
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    print(s.build_tree(preorder, inorder))
