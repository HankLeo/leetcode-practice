function letterCombinations(digits: string): string[] {
    const res: string[] = [];
    const map: Record<string, string> = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
    };

    const backtrack = (index: number, path: string) => {
        if (path.length === digits.length) {
            res.push(path);
            return;
        }
        for (let i = index; i < digits.length; i++) {
            const letters = map[digits[index]];
            for (const letter of letters) {
                backtrack(i + 1, path + letter);
            }
        }
    };

    if (digits.length > 0) {
        backtrack(0, '');
    }
    return res;
}

console.log(letterCombinations('23'));
