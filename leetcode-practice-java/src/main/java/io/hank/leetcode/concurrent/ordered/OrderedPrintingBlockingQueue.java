package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderedPrintingBlockingQueue {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final BlockingQueue<Integer>[] queues;
    private static final int THREAD_COUNT = 3;

    static {
        queues = new BlockingQueue[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            queues[i] = new LinkedBlockingQueue<>();
        }
        queues[0].offer(1); // 第一个线程先执行
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
                    queues[threadId].take();

                    if (counter > MAX) {
                        queues[(threadId + 1) % THREAD_COUNT].put(1);
                        break;
                    }

                    System.out.println("Thread-" + threadId + ": " + counter++);
                    queues[(threadId + 1) % THREAD_COUNT].put(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
