package io.hank.leetcode.kotlin.complexity

import java.lang.reflect.Method

object ComplexityProcessor {
    inline fun <reified T : Any> printComplexity(obj: T) {
        try {
            obj::class.java.declaredMethods.forEach { method ->
                val timeComplexity = method.getAnnotation(TimeComplexity::class.java)
                val spaceComplexity = method.getAnnotation(SpaceComplexity::class.java)

                if (timeComplexity != null || spaceComplexity != null) {
                    println("Method Name: ${method.name}")
                    timeComplexity?.let { println("Time Complexity: ${it.value}") }
                    spaceComplexity?.let { println("Space Complexity: ${it.value}") }

                }
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }
    }
}