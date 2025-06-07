from libs.treenode import TreeNode


class Solution:
    def sorted_array_to_bst(self, nums: list[int]) -> TreeNode | None:
        def helper(left, right):
            if left > right:
                return None

            # 总是选择中间位置左边的数字作为根节点
            mid = (left + right) // 2

            root = TreeNode(nums[mid])
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)
            return root

        return helper(0, len(nums) - 1)


if __name__ == "__main__":
    nums = [-10, -3, 0, 5, 9]
    solution = Solution()
    print(solution.sorted_array_to_bst(nums))
