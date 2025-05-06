package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderedPrintingCountDownLatch {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final int MAX = 100;
    private static final CountDownLatch[] latches;
    private static final int THREAD_COUNT = 3;

    static {
        latches = new CountDownLatch[THREAD_COUNT];
        latches[0] = new CountDownLatch(0); // 第一个线程可以直接执行
        for (int i = 1; i < THREAD_COUNT; i++) {
            latches[i] = new CountDownLatch(1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
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
                try {
                    latches[threadId].await();

                    int current = counter.get();
                    if (current > MAX) {
                        latches[(threadId + 1) % THREAD_COUNT].countDown();
                        break;
                    }

                    System.out.println("Thread-" + threadId + ": " + current);
                    counter.incrementAndGet();

                    latches[threadId] = new CountDownLatch(1); // 重置自己的latch
                    latches[(threadId + 1) % THREAD_COUNT].countDown(); // 唤醒下一个线程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
