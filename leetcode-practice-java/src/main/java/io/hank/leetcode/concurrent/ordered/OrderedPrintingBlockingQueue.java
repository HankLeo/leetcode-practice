package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OrderedPrintingBlockingQueue {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final BlockingQueue<Integer>[] queues;
    private static final int THREAD_COUNT = 3;

    static {
        queues = new BlockingQueue[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            queues[i] = new ArrayBlockingQueue<>(1);
        }
        queues[0].offer(1); // 第一个线程先执行
    }

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                while (counter <= MAX) {
                    try {
                        queues[threadId].take(); // 空队列等待
                        if (counter <= MAX) {
                            System.out.println("Thread-" + threadId + ": " + counter++);
                        }
                        queues[(threadId + 1) % THREAD_COUNT].put(1); // 将下一队列的信号量放入
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }).start();
        }
    }

}
