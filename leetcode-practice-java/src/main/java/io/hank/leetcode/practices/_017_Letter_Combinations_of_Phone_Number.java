package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017_Letter_Combinations_of_Phone_Number extends LeetcodeProblemSolution {
    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    @Topic({TopicType.BACKTRACK, TopicType.RECURSION})
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder prefix, String digits, int index) {
        if (index == digits.length()) {
            // end the recursion
            result.add(prefix.toString());
            return;
        }
        char digit = digits.charAt(index);
        String cur = map.get(digit);
        for (char c : cur.toCharArray()) {
            prefix.append(c);
            backtrack(result, prefix, digits, index + 1);
            // backtracking
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
