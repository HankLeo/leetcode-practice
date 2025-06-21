import itertools


class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        visited = [False] * n
        ans = list()
        permutation = list()

        def backtrack():
            if len(permutation) == n:
                ans.append(list(permutation))
                return
            for i in range(n):
                if not visited[i]:
                    visited[i] = True
                    permutation.append(nums[i])
                    backtrack()
                    permutation.pop()
                    visited[i] = False

        backtrack()
        return ans

    def permute_direct(self, nums: list[int]) -> list[list[int]]:
        return list(itertools.permutations(nums))


if __name__ == '__main__':
    s = Solution()
    print(s.permute([1, 2, 3]))
    print(s.permute_direct([1, 2, 3]))
