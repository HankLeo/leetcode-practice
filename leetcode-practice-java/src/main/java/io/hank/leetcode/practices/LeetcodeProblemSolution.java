package io.hank.leetcode.practices;

import io.hank.leetcode.complexity.ComplexityProcessor;

public abstract class LeetcodeProblemSolution {
    public void execute() {
        System.out.println("==== Problem: " + this.getClass().getSimpleName() + " ====");
        ComplexityProcessor.printComplexity(this);
    }
}
