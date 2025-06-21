class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[left] == target:
                return left
            if nums[right] == target:
                return right
            if nums[0] < nums[mid]:
                # 在rotated递增序列中
                if nums[0] < target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # 在原始递增序列中
                if nums[mid] < target < nums[len(nums) - 1]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1


if __name__ == '__main__':
    s = Solution()
    print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
    print(s.search([4, 5, 6, 7, 0, 1, 2], 3))
