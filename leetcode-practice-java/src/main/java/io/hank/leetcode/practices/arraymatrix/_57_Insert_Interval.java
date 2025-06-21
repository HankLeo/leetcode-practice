package io.hank.leetcode.practices.arraymatrix;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 * </pre>
 */
public class _57_Insert_Interval extends LeetcodeProblemSolution {

    @Topic(TopicType.ARRAY)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        int mergedLeft = left, mergedRight = right;
        boolean merged = false;
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                // 当前区间在newInterval左边且不重叠
                ans.add(interval);
            } else if (interval[0] > right) {
                // 当前区间在newInterval右边且不重叠
                if (!merged) {
                    ans.add(new int[]{mergedLeft, mergedRight});
                    merged = true;
                }
                ans.add(interval);
            } else {
                // 当前区间与newInterval重叠，合并
                mergedLeft = Math.min(mergedLeft, interval[0]);
                mergedRight = Math.max(mergedRight, interval[1]);
            }
        }
        // 循环结束后，如果还未添加合并后的区间，则添加
        if (!merged) {
            ans.add(new int[]{mergedLeft, mergedRight});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
