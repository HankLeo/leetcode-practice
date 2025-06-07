import itertools


class Solution:
    def letter_combinations(self, digits: str) -> list[str]:
        if not digits:
            return list()

        phone_map = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }

        def backtrack(index: int):
            if index == len(digits):
                result.append("".join(combination))
            else:
                digit = digits[index]
                for letter in phone_map[digit]:
                    combination.append(letter)
                    backtrack(index + 1)
                    combination.pop()

        combination = list()
        result = list()
        backtrack(0)
        return result

    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return list()

        phone_map = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }

        groups = (phone_map[digit] for digit in digits)
        return ["".join(combination) for combination in itertools.product(*groups)]


if __name__ == "__main__":
    solution = Solution()
    print("回溯法结果:")
    print(solution.letter_combinations("23"))
    print("itertools.product 法结果:")
    print(solution.letterCombinations("23"))
