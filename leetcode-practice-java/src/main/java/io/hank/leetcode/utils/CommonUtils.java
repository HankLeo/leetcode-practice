package io.hank.leetcode.utils;

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
}
