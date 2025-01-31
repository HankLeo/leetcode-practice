package io.hank.leetcode.practices;

import java.lang.reflect.Method;
import java.util.Arrays;

import io.hank.leetcode.annotations.SpaceComplexity;
import io.hank.leetcode.annotations.TimeComplexity;
import io.hank.leetcode.annotations.Topic;

public abstract class LeetcodeProblemSolution {
    public void execute() {
        System.out.println("\n==== Problem: " + this.getClass().getSimpleName() + " ====");
        LeetcodeAnnotationProcessor.printComplexity(this);
    }

    static class LeetcodeAnnotationProcessor {
        private LeetcodeAnnotationProcessor() {
            throw new IllegalStateException("Utility class");
        }

        public static <T> void printComplexity(T obj) {
            try {
                Method[] methods = obj.getClass().getDeclaredMethods();
                Arrays.stream(methods).forEach((method -> {
                    Topic topic = method.getAnnotation(Topic.class);
                    TimeComplexity timeComplexity = method.getAnnotation(TimeComplexity.class);
                    SpaceComplexity spaceComplexity = method.getAnnotation(SpaceComplexity.class);

                    if (topic != null || timeComplexity != null || spaceComplexity != null) {
                        System.out.println("Method Name: " + method.getName());
                    }
                    if (topic != null) {
                        System.out.println("Topic: " + Arrays.toString(topic.value()));
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
}
