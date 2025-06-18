function combine(n: number, k: number): number[][] {
    const ans: number[][] = [];
    const curList: number[] = [];

    function backtrack(curNum: number) {
        if (curList.length == k) {
            ans.push([...curList]);
            return;
        }

        for (let i = curNum; i <= n; i++) {
            curList.push(i);
            backtrack(i + 1);
            curList.pop();
        }
    }

    backtrack(1);
    return ans;
}

console.log(combine(4, 2))
console.log(combine(1, 1))
