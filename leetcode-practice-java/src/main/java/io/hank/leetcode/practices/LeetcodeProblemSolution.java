package io.hank.leetcode.practices;

import io.hank.leetcode.utils.CommonUtils;

public abstract class LeetcodeProblemSolution {
    public void execute() {
        CommonUtils.printProblemName(this);
        CommonUtils.printComplexityAnnotations(this, 1);
    }
}
