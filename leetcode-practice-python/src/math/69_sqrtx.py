class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        if 0 < x < 4:
            return 1
        low, high = 2, x // 2
        while low <= high:
            mid = low + (high - low) // 2
            # 防止平方溢出
            res = x // mid
            if res == mid:
                return mid
            if res < mid:
                high = mid - 1
            else:
                low = mid + 1
        return high


if __name__ == '__main__':
    s = Solution()
    print(s.mySqrt(4))
    print(s.mySqrt(8))
    print(s.mySqrt(9))
