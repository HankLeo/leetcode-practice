package io.hank.leetcode.practices;

import java.util.ArrayList;
import java.util.List;

import io.hank.leetcode.annotations.*;

/**
 * <pre>
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * </pre>
 */
public class _763_Partition_Labels extends LeetcodeProblemSolution {

    @Topic(TopicType.GREEDY)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    List<Integer> partitionLabels(String s) {
        int[] lastIndexOfChar = new int[128];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[s.charAt(i)] = i;
        }

        List<Integer> result = new ArrayList<>();
        int lastPartition = 0;
        int lastIndex = lastIndexOfChar[s.charAt(0)];
        for (int i = 1; i < s.length(); i++) {
            if (i > lastIndex) {
                result.add(i - lastPartition);
                lastPartition = i;
                lastIndex = lastIndexOfChar[s.charAt(i)];
            } else if (lastIndex < lastIndexOfChar[s.charAt(i)]) {
                lastIndex = lastIndexOfChar[s.charAt(i)];
            }
        }
        result.add(s.length() - lastPartition);
        return result;
    }

    @Override
    public void execute() {
        super.execute();

        String s = "ababcbacadefegdehijhklij";
        System.out.println("Input: s = " + s);
        List<Integer> result1 = partitionLabels(s);
        System.out.println("Output: " + result1.toString());
    }
}
