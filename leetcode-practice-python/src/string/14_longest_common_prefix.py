class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""

        m, n = len(strs), len(strs[0])
        for i in range(n):
            char = strs[0][i]
            if any(i == len(strs[j]) or strs[j][i] != char for j in range(1, m)):
                return strs[0][:i]
        return strs[0]


if __name__ == "__main__":
    s = Solution()
    print(s.longestCommonPrefix(["flower", "flow", "flight"]))
    print(s.longestCommonPrefix(["dog", "racecar", "car"]))
