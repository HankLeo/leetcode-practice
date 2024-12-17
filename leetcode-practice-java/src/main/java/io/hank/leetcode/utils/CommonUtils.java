package io.hank.leetcode.utils;

import java.lang.reflect.Method;

import io.hank.leetcode.annotations.SpaceComplexity;
import io.hank.leetcode.annotations.TimeComplexity;

public class CommonUtils {
    private CommonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> void printProblemName(T obj) {
        if (obj == null) {
            System.out.println("Exception!!!");
            return;
        }
        System.out.println("==== Problem: " + obj.getClass().getSimpleName() + " ====");
    }

    public static <T> void printComplexityAnnotations(T obj, int methodIndex) {
        try {
            Method method = obj.getClass().getDeclaredMethods()[methodIndex];

            System.out.println("Method Name: " + method.getName());

            // print TimeComplexity
            if (method.isAnnotationPresent(TimeComplexity.class)) {
                TimeComplexity timeComplexity = method.getAnnotation(TimeComplexity.class);
                System.out.println("Time Complexity: " + timeComplexity.value());
            }

            // print SpaceComplexity
            if (method.isAnnotationPresent(SpaceComplexity.class)) {
                SpaceComplexity spaceComplexity = method.getAnnotation(SpaceComplexity.class);
                System.out.println("Space Complexity: " + spaceComplexity.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
