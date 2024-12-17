package io.hank.leetcode.complexity;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ComplexityProcessor {
    private ComplexityProcessor() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> void printComplexity(T obj) {
        try {
            Method[] methods = obj.getClass().getDeclaredMethods();
            Arrays.stream(methods).forEach((method -> {
                TimeComplexity timeComplexity = method.getAnnotation(TimeComplexity.class);
                SpaceComplexity spaceComplexity = method.getAnnotation(SpaceComplexity.class);

                if (timeComplexity != null || spaceComplexity != null) {
                    System.out.println("Method Name: " + method.getName());
                }
                if (timeComplexity != null) {
                    System.out.println("Time Complexity: " + timeComplexity.value());
                }
                if (spaceComplexity != null) {
                    System.out.println("Space Complexity: " + spaceComplexity.value());
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
