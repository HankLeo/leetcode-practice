class Solution:
    def solve(self, board: list[list[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # only border's 'O' cannot be surrounded, so pick as starters
        m, n = len(board), len(board[0])

        def dfs(i: int, j: int):
            if i < 0 or i >= m or j < 0 or j >= n or board[i][j] != "O":
                return
            board[i][j] = "Y"
            dfs(i + 1, j)
            dfs(i, j + 1)
            dfs(i - 1, j)
            dfs(i, j - 1)

        # mark starters as 'Y'
        for i in range(m):
            if board[i][0] == "O":
                dfs(i, 0)
            if board[i][n - 1] == "O":
                dfs(i, n - 1)
        for j in range(n):
            if board[0][j] == "O":
                dfs(0, j)
            if board[m - 1][j] == "O":
                dfs(m - 1, j)

        for i in range(m):
            for j in range(n):
                if board[i][j] == "Y":
                    board[i][j] = "O"
                else:
                    board[i][j] = "X"


if __name__ == '__main__':
    s = Solution()
    _board = [["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]]
    s.solve(_board)
    print(_board)
    _board = [["X", "X", "X", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"], ["X", "O", "X", "X"]]
    s.solve(_board)
    print(_board)
