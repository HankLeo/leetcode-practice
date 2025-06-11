class Solution:
    def jump(self, nums: list[int]) -> int:
        n = len(nums)
        rightmost, last_right, step = 0, 0, 0
        for i in range(n - 1):
            if i <= rightmost:
                rightmost = max(rightmost, i + nums[i])
                if rightmost >= n - 1:
                    return step + 1
                # 遍历当前下标到rightmost下标之间的元素，都视作为1步
                if i == last_right:
                    last_right = rightmost
                    step += 1
        return step


if __name__ == "__main__":
    s = Solution()
    print(s.jump([2, 3, 1, 1, 4]))
    print(s.jump([2, 3, 0, 1, 4]))
