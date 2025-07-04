class Solution:
    def roman_to_int(self, s: str) -> int:
        # 从右往左迭代，遇到大于等于的就加，遇到小于的就减
        keys = ["I", "V", "X", "L", "C", "D", "M"]
        values = [1, 5, 10, 50, 100, 500, 1000]
        roman_dict = dict(zip(keys, values))
        ans = roman_dict[s[-1]]  # 最后一位一定是加法
        for index in range(-2, -len(s) - 1, -1):
            char = s[index]
            last_char = s[index + 1]
            if roman_dict[char] >= roman_dict[last_char]:
                ans += roman_dict[char]
            else:
                ans -= roman_dict[char]
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.roman_to_int("III"))
    print(s.roman_to_int("LVIII"))
    print(s.roman_to_int("MCMXCIV"))
