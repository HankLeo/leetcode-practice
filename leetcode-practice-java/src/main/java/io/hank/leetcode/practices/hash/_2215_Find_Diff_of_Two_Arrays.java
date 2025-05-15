package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2215_Find_Diff_of_Two_Arrays extends LeetcodeProblemSolution {

    @Topic({TopicType.HASH})
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }

        Set<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);
        Set<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(diff1));
        res.add(new ArrayList<>(diff2));
        return res;
    }
}
