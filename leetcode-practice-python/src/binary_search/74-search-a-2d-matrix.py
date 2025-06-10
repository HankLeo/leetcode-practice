class Solution:
    @staticmethod
    def search_matrix(matrix: list[list[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        low, high = -1, m * n
        while low + 1 < high:
            mid = (low + high) // 2
            x = matrix[mid // n][mid % n]
            if x == target:
                return True
            elif x > target:
                high = mid
            else:
                low = mid
        return False


if __name__ == "__main__":
    sol = Solution()
    print(sol.search_matrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))
    print(sol.search_matrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 13))
