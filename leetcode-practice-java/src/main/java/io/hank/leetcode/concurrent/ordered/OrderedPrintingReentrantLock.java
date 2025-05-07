package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 每个线程各检查1个不同的Condition，通过Condition依次唤醒下一个线程
 */
public class OrderedPrintingReentrantLock {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition[] conditions;
    private static int currentThread = 0;

    static {
        int threadCount = 3; // 线程数量
        conditions = new Condition[threadCount];
        for (int i = 0; i < threadCount; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<?>[] futures = new CompletableFuture[conditions.length];
        for (int i = 0; i < conditions.length; i++) {
            final int threadId = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                while (counter <= MAX) {
                    lock.lock();
                    try {
                        // 如果不是当前线程，等待
                        // 使用while循环防止虚假唤醒
                        while (currentThread != threadId) {
                            conditions[threadId].await();
                        }
                        // 打印数字
                        if (counter <= MAX) {
                            System.out.println("Thread-" + currentThread + ": " + counter++);
                        }
                        // 通知下一个线程
                        currentThread = (currentThread + 1) % conditions.length;
                        conditions[currentThread].signal();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    } finally {
                        // 确保释放锁
                        lock.unlock();
                    }
                }
            });
        }
        CompletableFuture.allOf(futures).join();
    }

}
