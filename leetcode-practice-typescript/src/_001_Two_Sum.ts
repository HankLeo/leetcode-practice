function twoSum(nums: number[], target: number): number[] {
  const numMap = new Map<number, number>();
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (numMap.has(complement)) {
      return [numMap.get(complement)!, i];
    }
    numMap.set(nums[i], i);
  }

  return []; // no matched
}

export function execute() {
  const result1 = twoSum([2, 7, 11, 15], 9);
  console.log(result1);

  const result2 = twoSum([2, 3, 4], 6);
  console.log(result2);

  const result3 = twoSum([3, 3], 6);
  console.log(result3);
}
