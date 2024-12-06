/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 *
 * Output: [0,1]
 *
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 *
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 *
 * Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 10^4
 *
 * -10^9 <= nums[i] <= 10^9
 *
 * -10^9 <= target <= 10^9
 *
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
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
