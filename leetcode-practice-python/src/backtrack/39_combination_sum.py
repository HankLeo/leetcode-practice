class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        ans, cur_com, n = list(), list(), len(candidates)

        def backtrack(cur_index: int, remain: int):
            if remain == 0:
                ans.append(list(cur_com))
            if remain < 0:
                return
            for i in range(cur_index, n):
                cur_com.append(candidates[i])
                backtrack(i, remain - candidates[i])
                cur_com.pop()

        backtrack(0, target)
        return ans


if __name__ == "__main__":
    s = Solution()
    print(s.combinationSum([2, 3, 6, 7], 7))
    print(s.combinationSum([2, 3, 5], 8))
    print(s.combinationSum([2], 1))
    print(s.combinationSum([1], 1))
