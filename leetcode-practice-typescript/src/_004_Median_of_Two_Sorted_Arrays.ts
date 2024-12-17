/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * <p>
 * Output: 2.00000
 * <p>
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * <p>
 * Output: 2.50000
 * <p>
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  const n1 = nums1.length
  const n2 = nums2.length
  const n = n1 + n2

  if (n1 > n2) {
    return findMedianSortedArrays(nums2, nums1)
  }

  const midSize = Math.floor((n + 1) / 2)
  let left = 0
  let right = n1

  while (left <= right) {
    let mid1 = Math.floor((left + right) / 2)
    let mid2 = midSize - mid1

    let r1 = mid1 < n1 ? nums1[mid1] : Number.MAX_SAFE_INTEGER
    let r2 = mid2 < n2 ? nums2[mid2] : Number.MAX_SAFE_INTEGER
    let l1 = (mid1 - 1) >= 0 ? nums1[mid1 - 1] : Number.MIN_SAFE_INTEGER
    let l2 = (mid2 - 1) >= 0 ? nums2[mid2 - 1] : Number.MIN_SAFE_INTEGER

    if (l1 <= r2 && l2 <= r1) {
      if (n % 2 == 1) {
        return Math.max(l1, l2)
      } else {
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2
      }
    } else if (l1 > r2) {
      right = mid1 - 1
    } else {
      left = mid1 + 1
    }
  }

  return 0
}

export function execute() {
  console.log('==== Problem: _004_Median_of_Two_Sorted_Arrays ====')

  // Example 1
  let nums1 = [3]
  let nums2 = [-2, -1]
  console.log(`Input: nums1 = ${nums1}, nums2 = ${nums2}`)
  console.log(`Output: ${findMedianSortedArrays(nums1, nums2)}`)
}
