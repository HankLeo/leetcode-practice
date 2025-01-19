package io.hank.leetcode.practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.hank.leetcode.annotations.*;

public class _451_Sort_Characters_By_Frequency extends LeetcodeProblemSolution {

    @Topic(TopicType.SORT_AND_SELECTION)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    String frequencySort(String s) {
        // key: char, val: freq
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // buckets array
        // index: freq (0..s.length()), val: list of char
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        freqMap.forEach((c, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList();
            }
            buckets[freq].add(c);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    sb.append(String.valueOf(c).repeat(i));
                }
            }
        }
        return sb.toString();
    }
}
