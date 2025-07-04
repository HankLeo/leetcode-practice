class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        a, b, c = nums[0], nums[1], nums[n - 1]
        min_delta = abs(a + b + c - target)
        ans = a + b + c
        if min_delta == 0:
            return target

        # 迭代每个a的可能值
        for i in range(0, n - 2):
            a = nums[i]
            # 迭代每个b和c的可能
            j, k = i + 1, n - 1
            while j < k:
                b, c = nums[j], nums[k]
                sum_of_abc = a + b + c
                new_diff = abs(sum_of_abc - target)
                if sum_of_abc > target:
                    k -= 1
                elif sum_of_abc == target:
                    return target
                else:
                    j += 1
                if new_diff < min_delta:
                    min_delta = new_diff
                    ans = sum_of_abc

        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.threeSumClosest([-1, 2, 1, -4], 1))
    print(s.threeSumClosest([0, 0, 0], 1))
    print(s.threeSumClosest([1, 1, 1, 0], -100))
