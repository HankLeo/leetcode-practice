class Solution:
    def longest_palindrome(self, s: str) -> str:
        # 遍历每个点成为回文中心点的可能，分奇偶数
        max_start, max_end, max_len = 0, 0, 0

        def longest_palindrome_of_center(left: int, right: int) -> [int]:
            while left >= 0 and right < len(s):
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                else:
                    break
            return [left + 1, right - 1]

        for i in range(len(s)):
            odd_pair = longest_palindrome_of_center(i, i)
            odd_len = odd_pair[1] - odd_pair[0] + 1
            even_pair = longest_palindrome_of_center(i, i + 1)
            even_len = even_pair[1] - even_pair[0] + 1
            if odd_len > max_len:
                max_len = odd_len
                max_start = odd_pair[0]
                max_end = odd_pair[1]
            if even_len > max_len:
                max_len = even_len
                max_start = even_pair[0]
                max_end = even_pair[1]

        return s[max_start:max_end + 1]


if __name__ == '__main__':
    s = "babad"
    print(Solution().longest_palindrome(s))
