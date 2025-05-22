package io.hank.leetcode.practices.twopointer;

import io.hank.leetcode.practices.LeetcodeProblemSolution;

/**
 * <pre>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^4
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * </pre>
 */
public class _151_Reverse_Words_in_String extends LeetcodeProblemSolution {

    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        int start = n - 1, end = n - 1;
        while (start >= 0) {
            // 跳过末尾空格
            if (s.charAt(end) == ' ') {
                end--;
                start--;
                continue;
            }

            // 找到单词开头
            if (s.charAt(start) != ' ') {
                start--;
                continue;
            }

            // start为单词前一位的空格，end为单词结尾，添加单词到结果中
            result.append(s, start + 1, end + 1).append(' ');
            end = start;
        }
        // 如果s不是以空格开头，则会多出一个单词需要添加
        if (start != end) {
            result.append(s, start + 1, end + 1).append(' ');
        }

        // 删除最后一个多余的空格
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
