class Solution:
    @staticmethod
    def num_islands(grid: list[list[str]]) -> int:
        ans = 0
        m = len(grid)
        n = len(grid[0])

        def dfs(i: int, j: int):
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == "0":
                return
            grid[i][j] = "0"
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)

        for row in range(m):
            for col in range(n):
                if grid[row][col] == "1":
                    ans += 1
                    dfs(row, col)
        return ans


if __name__ == "__main__":
    sol = Solution()
    print(sol.num_islands(
        [["1", "1", "1", "0", "0", "0"],
         ["1", "1", "0", "0", "1", "0"],
         ["1", "0", "0", "1", "0", "0"],
         ["0", "0", "0", "0", "0", "0"]]))
