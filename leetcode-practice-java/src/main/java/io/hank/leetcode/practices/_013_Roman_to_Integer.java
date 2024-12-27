package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityType;
import io.hank.leetcode.complexity.SpaceComplexity;
import io.hank.leetcode.complexity.TimeComplexity;

public class _013_Roman_to_Integer extends LeetcodeProblemSolution {

    @TimeComplexity(ComplexityType.O_N)
    @SpaceComplexity(ComplexityType.O_1)
    int romanToInt(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            number = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (prev > number) {
                answer -= number;
            } else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}
