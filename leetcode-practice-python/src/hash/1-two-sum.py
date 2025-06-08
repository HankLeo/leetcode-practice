class Solution:
    def two_sum(self, nums: list[int], target: int) -> list[int]:
        diffs = {}
        for index, num in enumerate(nums):
            diff = target - num
            if diff in diffs:
                return [index, diffs[diff]]
            diffs[num] = index
        return [0, 0]


if __name__ == "__main__":
    _nums = [2, 7, 11, 15]
    _target = 9
    solution = Solution()
    result = solution.two_sum(_nums, _target)
    print(result)
