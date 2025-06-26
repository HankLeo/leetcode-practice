class Solution:
    def is_subsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        p1, p2 = 0, 0
        while p1 < len(s) and p2 < len(t):
            while p2 < len(t) and s[p1] != t[p2]:
                p2 += 1
            if p2 == len(t):
                break
            p1 += 1
            p2 += 1
        return p1 == len(s)


if __name__ == "__main__":
    s = Solution()
    print(s.is_subsequence("abc", "ahbgdc"))
    print(s.is_subsequence("axc", "ahbgdc"))
