class Solution:
    def canJump(self, nums: list[int]) -> bool:
        n, rightmost = len(nums), 0
        for i in range(n):
            if i <= rightmost:
                rightmost = max(rightmost, i + nums[i])
            else:
                return False
        return True


if __name__ == "__main__":
    sol = Solution()
    print(sol.canJump([2, 3, 1, 1, 4]))
    print(sol.canJump([3, 2, 1, 0, 4]))
