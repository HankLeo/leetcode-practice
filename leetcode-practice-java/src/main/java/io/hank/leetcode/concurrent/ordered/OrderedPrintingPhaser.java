package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.Phaser;

public class OrderedPrintingPhaser {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final Phaser phaser = new Phaser(1); // 初始注册数为1

    public static void main(String[] args) {
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Printer(i, threadCount)).start();
        }
    }

    static class Printer implements Runnable {
        private final int threadId;
        private final int totalThreads;

        public Printer(int threadId, int totalThreads) {
            this.threadId = threadId;
            this.totalThreads = totalThreads;
            phaser.register();
        }

        @Override
        public void run() {
            while (true) {
                phaser.arriveAndAwaitAdvance();

                if (counter > MAX) {
                    phaser.arriveAndDeregister();
                    break;
                }

                if (phaser.getPhase() % totalThreads == threadId) {
                    System.out.println("Thread-" + threadId + ": " + counter++);
                }
            }
        }
    }
}
