class Solution:
    def max_profit(self, prices: list[int]) -> int:
        # 贪心求和
        ans = 0
        n = len(prices)
        for i in range(1, n):
            if prices[i] > prices[i - 1]:
                ans += prices[i] - prices[i - 1]  # 只要是递增都算成收益
        return ans


if __name__ == "__main__":
    solution = Solution()
    print(solution.max_profit([7, 1, 5, 3, 6, 4]))
    print(solution.max_profit([1, 2, 3, 4, 5]))
