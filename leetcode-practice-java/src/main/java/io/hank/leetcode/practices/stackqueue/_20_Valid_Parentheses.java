package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * </pre>
 */
public class _20_Valid_Parentheses extends LeetcodeProblemSolution {

    @Topic(TopicType.STACK)
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            }
            if (c == ')') {
                if (deque.isEmpty()) {
                    return false;
                }
                char pre = deque.pop();
                if (pre != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (deque.isEmpty()) {
                    return false;
                }
                char pre = deque.pop();
                if (pre != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (deque.isEmpty()) {
                    return false;
                }
                char pre = deque.pop();
                if (pre != '{') {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
