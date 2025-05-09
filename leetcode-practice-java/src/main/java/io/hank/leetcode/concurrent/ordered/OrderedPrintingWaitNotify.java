package io.hank.leetcode.concurrent.ordered;

public class OrderedPrintingWaitNotify {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final Object lock = new Object();
    private static int currentThread = 0; // 当前应该执行的线程ID

    public static void main(String[] args) {
        int threadCount = 3; // 线程数量
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            new Thread(() -> {
                while (counter <= MAX) {
                    synchronized (lock) {
                        // 如果不是当前线程，等待
                        while (currentThread != threadId) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        // 如果是当前线程，打印数字并通知其他所有线程
                        if (counter <= MAX) {
                            System.out.println("Thread-" + threadId + ": " + counter++);
                        }
                        currentThread = (currentThread + 1) % threadCount;
                        lock.notifyAll(); // 缺点是只能通知其余所有线程
                    }
                }
            }).start();
        }
    }

}