package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * 给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * </pre>
 */
public class _1207_Unique_Num_of_Occurrences extends LeetcodeProblemSolution {

    @Topic(TopicType.HASH)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int num : arr) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : numCnt.entrySet()) {
            int cnt = entry.getValue();
            if (set.contains(cnt)) {
                return false;
            }
            set.add(cnt);
        }
        return true;
    }
}
