package io.hank.leetcode.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 用 CyclicBarrier 代替Thread.sleep()
 */
public class PrintNumbersCyclicBarrier {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        if (counter > MAX) {
            System.exit(0);
        }
    });

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
                synchronized (PrintNumbersCyclicBarrier.class) {
                    if (counter > MAX) {
                        break;
                    }
                    System.out.println("Thread-" + threadId + ": " + counter++);
                }
                try {
                    barrier.await(); // 等待所有线程到达屏障
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
