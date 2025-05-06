package io.hank.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger实现无锁同步打印1-100，无法保证顺序
 */
public class PrintNumbersAtomic {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final int MAX = 100;

    public static void main(String[] args) {
        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Printer(i)).start();
        }
    }

    static class Printer implements Runnable {
        private final int threadId;

        public Printer(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                int current = counter.getAndIncrement();
                if (current > MAX) {
                    break;
                }
                System.out.println("Thread-" + threadId + ": " + current); // 这里无锁，所以不能保证顺序打印
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
