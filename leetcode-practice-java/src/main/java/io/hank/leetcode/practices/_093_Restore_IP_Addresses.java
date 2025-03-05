package io.hank.leetcode.practices;

import io.hank.leetcode.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 * </pre>
 */
public class _093_Restore_IP_Addresses extends LeetcodeProblemSolution {

    @Topic({TopicType.BACKTRACK, TopicType.RECURSION})
    @TimeComplexity(ComplexityType.O_3N)
    @SpaceComplexity(ComplexityType.O_N)
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> ip, String s, int index) {
        if (ip.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", ip));
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) {
                break;
            }
            String part = s.substring(index, index + i);
            if (isValid(part)) {
                ip.add(part);
                backtrack(result, ip, s, index + i);
                ip.remove(ip.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
