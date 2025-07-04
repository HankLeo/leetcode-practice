class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        n = len(nums)
        left, right, ans = 0, n - 1, n
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.searchInsert([1, 3, 5, 6], 5))
    print(s.searchInsert([1, 3, 5, 6], 2))
    print(s.searchInsert([1, 3, 5, 6], 7))
