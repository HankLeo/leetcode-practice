class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {
            '(': ')',
            '[': ']',
            '{': '}',
        }
        stack = list()
        for c in s:
            if c in pairs:
                stack.append(c)
            elif len(stack) == 0 or pairs[stack.pop()] != c:
                return False
        return len(stack) == 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.isValid("()[]{}"))
    print(sol.isValid("(]"))
    print(sol.isValid("([)]"))
