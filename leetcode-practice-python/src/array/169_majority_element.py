class Solution:
    def majority_element(self, nums: list[int]) -> int:
        votes = 0
        for num in nums:
            if votes == 0:
                x = num
            votes += 1 if num == x else -1
        return x


if __name__ == "__main__":
    s = Solution()
    print(s.majority_element([2, 2, 1, 1, 1, 2, 2]))
