package io.hank.leetcode.practices.search;

import io.hank.leetcode.annotations.*;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.*;

/**
 * <pre>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * </pre>
 */
public class _127_Word_Ladder extends LeetcodeProblemSolution {

    @Topic({TopicType.BFS, TopicType.TREE})
    @TimeComplexity(ComplexityType.O_MN)
    @SpaceComplexity(ComplexityType.O_N)
    int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        Set<String> words = new HashSet<>(wordList);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // loop all connected strings
                for (int j = 0; j < cur.length(); j++) {
                    char[] chars = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) {
                            continue;
                        }
                        chars[j] = c;
                        String next = new String(chars);
                        if (words.contains(next)) {
                            if (next.equals(endWord)) {
                                return level;
                            }
                            queue.add(next);
                            words.remove(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

}
