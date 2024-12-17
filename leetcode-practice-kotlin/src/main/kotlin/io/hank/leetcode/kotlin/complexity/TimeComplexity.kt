package io.hank.leetcode.kotlin.complexity

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class TimeComplexity(val value: ComplexityType)
