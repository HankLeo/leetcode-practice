function combinationSum3(k: number, n: number): number[][] {
    const res: number[][] = [];
    const curAns: number[] = [];

    function backtrack(target: number, start: number) {
        if (curAns.length === k && target === 0) {
            // 是正确解
            res.push([...curAns]);
            return;
        }
        if (start > target) {
            // 太大了
            return;
        }
        for (let i = start; i <= 9; i++) {
            curAns.push(i);
            backtrack(target - i, i + 1);
            curAns.pop();
        }
    }

    backtrack(n, 1);
    return res;
}

console.log(combinationSum3(3, 9));
