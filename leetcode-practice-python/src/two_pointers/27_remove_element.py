class Solution:
    def remove_element(self, nums: list[int], val: int) -> int:
        left, right, n = 0, 0, len(nums)
        while right < n:
            if nums[right] == val:
                right += 1
                continue
            nums[left] = nums[right]
            left += 1
            right += 1
        return left


if __name__ == "__main__":
    s = Solution()
    print(s.remove_element([3, 2, 2, 3], 3))
    print(s.remove_element([0, 1, 2, 2, 3, 0, 4, 2], 2))
