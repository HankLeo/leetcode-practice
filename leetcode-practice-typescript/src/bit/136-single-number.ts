function singleNumber(nums: number[]): number {
    // 任何数和0抑或等于自己
    // 任何数和自己抑或等于0
    let res = 0;
    for (const num of nums) {
        res ^= num;
    }
    return res;
}

console.log(singleNumber([2, 2, 1]));
