class Solution:
    def coin_change(self, coins: list[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount + 1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        return dp[amount] if dp[amount] != amount + 1 else -1


if __name__ == "__main__":
    s = Solution()
    print(s.coin_change([1, 2, 5], 11))
    print(s.coin_change([2], 3))
