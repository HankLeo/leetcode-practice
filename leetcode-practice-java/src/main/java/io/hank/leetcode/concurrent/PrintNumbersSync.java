package io.hank.leetcode.concurrent;

/**
 * 打印1-100，多线程同步
 * 线程间没有先后次序
 * 依靠synchronized关键字来保证线程安全
 * 依靠Thread.sleep来保证打印顺序
 */
public class PrintNumbersSync {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        int threadCount = 5; // 线程数量
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
                synchronized (lock) {
                    if (counter > MAX) {
                        break;
                    }
                    System.out.println("Thread-" + threadId + ": " + counter++);
                }
                try {
                    Thread.sleep(10); // 稍微sleep一下让其他线程有机会获取锁
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
