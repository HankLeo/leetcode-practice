package io.hank.leetcode.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 使用ReentrantLock的lock和unlock方法来实现线程安全的数字打印，代替synchronized关键字。
 * 2. 使用CompletableFuture来启动多个线程，并等待所有线程执行完成，代替new Thread方式。
 * 3. 每个线程打印完数字后，线程会释放锁，让其他线程有机会执行打印操作，否则一个线程会连续占用资源。
 */
public class PrintNumbersReentrantLock {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        int threadCount = 5;
        CompletableFuture<?>[] futures = new CompletableFuture[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int threadId = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (counter > MAX) {
                            break;
                        }
                        System.out.println("Thread-" + threadId + ": " + counter++);
                    } finally {
                        lock.unlock();
                    }
                    try {
                        Thread.sleep(10); // 稍微sleep一下让其他线程有机会获取锁
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        CompletableFuture.allOf(futures).join();
    }

}
