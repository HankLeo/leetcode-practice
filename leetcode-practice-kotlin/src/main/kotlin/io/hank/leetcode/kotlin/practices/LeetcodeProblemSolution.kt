package io.hank.leetcode.kotlin.practices

import io.hank.leetcode.kotlin.complexity.ComplexityProcessor

abstract class LeetcodeProblemSolution {
    open fun execute() {
        println("==== Problem: ${this::class.simpleName} ====")
        ComplexityProcessor.printComplexity(this)
    }
}