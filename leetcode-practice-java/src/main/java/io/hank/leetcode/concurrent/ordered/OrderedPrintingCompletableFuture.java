package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderedPrintingCompletableFuture {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final int MAX = 100;

    public static void main(String[] args) {
        int threadCount = 3;
        CompletableFuture<Void>[] futures = new CompletableFuture[threadCount];

        // 初始化每个线程的CompletableFuture
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            futures[i] = new CompletableFuture<>();
        }

        // 设置链式依赖
        for (int i = 0; i < threadCount; i++) {
            final int nextThread = (i + 1) % threadCount;
            futures[i].thenRunAsync(() -> printNumber(nextThread, futures));
        }

        // 启动第一个线程
        futures[0].complete(null);

        // 等待所有线程完成
        CompletableFuture.allOf(futures).join();
    }

    private static void printNumber(int threadId, CompletableFuture<Void>[] futures) {
        int current = counter.getAndIncrement();
        if (current > MAX) {
            futures[threadId].complete(null);
            return;
        }

        System.out.println("Thread-" + threadId + ": " + current);
        futures[threadId].complete(null);
    }
}
