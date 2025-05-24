function productExceptSelf(nums: number[]): number[] {
    // 先用answer表示下标i左侧的所有数的乘积
    const n = nums.length;
    const answer = Array(n);
    answer[0] = 1;
    for (let i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }
    // 再逐个更新右侧的乘积
    let rightP = 1;
    for (let i = n - 2; i >= 0; i--) {
        rightP *= nums[i + 1];
        answer[i] *= rightP;
    }
    return answer;
}

console.log(productExceptSelf([1, 2, 3, 4]));
