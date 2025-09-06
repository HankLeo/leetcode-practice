class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        answer = [1] * n

        # 第一次遍历，计算不包含下标i的前缀积
        for i in range(1, n):
            answer[i] = answer[i - 1] * nums[i - 1]

        # 第二次遍历，计算后缀积，并乘以前缀积得到结果
        suffix = 1
        for i in range(n - 1, -1, -1):
            answer[i] = answer[i] * suffix
            suffix = suffix * nums[i]

        return answer


if __name__ == '__main__':
    s = Solution()
    print(s.productExceptSelf([1, 2, 3, 4]))
