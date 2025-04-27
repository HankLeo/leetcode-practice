package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * </pre>
 */
public class _394_Decode_String extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_N)
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        int curNum = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = 10 * curNum + (c - '0');
            } else if (c == '[') {
                numStack.push(curNum);
                strStack.push(sb);
                curNum = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                // pop
                int cnt = numStack.pop();
                StringBuilder preSb = strStack.pop();
                for (int i = 0; i < cnt; i++) {
                    preSb.append(sb.toString());
                }
                sb = preSb;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
