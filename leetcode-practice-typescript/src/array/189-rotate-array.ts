function rotate(nums: number[], k: number): void {
    const n = nums.length;
    const cnt = k % n;
    const temp = new Array(cnt);
    for (let i = 1; i <= cnt; i++) {
        temp[cnt - i] = nums[n - i];
    }
    for (let i = 1; i <= n - cnt; i++) {
        nums[n - i] = nums[n - i - cnt];
    }
    for (let i = 0; i < cnt; i++) {
        nums[i] = temp[i];
    }
}

const arr = [1, 2, 3, 4, 5, 6, 7];
rotate(arr, 3)
console.log(arr);
