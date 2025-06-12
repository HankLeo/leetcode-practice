class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        n = len(nums)
        res = []
        for first in range(n - 2):
            if nums[first] > 0:
                break
            # 需要不同的数
            if first > 0 and nums[first] == nums[first - 1]:
                continue
            target = -nums[first]
            second, third = first + 1, n - 1
            while second < third:
                # 需要不同的数
                if second > first + 1 and nums[second] == nums[second - 1]:
                    second += 1
                    continue
                sum = nums[second] + nums[third]
                if sum == target:
                    res.append([nums[first], nums[second], nums[third]])
                    # 继续找下一对second和third
                    second += 1
                    third -= 1
                elif sum > target:
                    third -= 1
                else:
                    second += 1
        return res


if __name__ == "__main__":
    sol = Solution()
    print(sol.threeSum([-1, 0, 1, 2, -1, -4]))
    print(sol.threeSum([0, 1, 1]))
