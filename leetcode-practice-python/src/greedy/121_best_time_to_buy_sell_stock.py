class Solution:
    def max_profit(self, prices: list[int]) -> int:
        max_profit = 0
        min_price = prices[0]
        for i in range(1, len(prices)):
            max_profit = max(max_profit, prices[i] - min_price)
            min_price = min(min_price, prices[i])
        return max_profit


if __name__ == "__main__":
    solution = Solution()
    print(solution.max_profit([7, 1, 5, 3, 6, 4]))
    print(solution.max_profit([7, 6, 4, 3, 1]))
