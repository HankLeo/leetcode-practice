package io.hank.leetcode.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 用 Semaphore 实现
 * 代替 synchronized 关键字
 */
public class PrintNumbersSemaphore {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final Semaphore semaphore = new Semaphore(1);

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
                try {
                    semaphore.acquire();
                    if (counter > MAX) {
                        semaphore.release();
                        break;
                    }
                    System.out.println("Thread-" + threadId + ": " + counter++);
                    semaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
