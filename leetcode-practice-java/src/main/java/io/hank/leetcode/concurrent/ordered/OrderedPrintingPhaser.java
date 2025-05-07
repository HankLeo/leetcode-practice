package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.Phaser;

public class OrderedPrintingPhaser {
    private static volatile int counter = 1;
    private static final int MAX = 100;
    private static final Phaser phaser = new Phaser(0); // 初始注册数为0

    public static void main(String[] args) {
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            phaser.register(); // 主线程为每个工作线程预先注册
            new Thread(() -> {
                while (true) {
                    int phase = phaser.arriveAndAwaitAdvance() - 1; // 当前线程到达并等待其他所有未到达的线程都到达后phase++
                    System.out.println("Thread-" + threadId + " unarrived parties: " + phaser.getUnarrivedParties());
                    if (counter > MAX) {
                        phaser.arriveAndDeregister();
                        break;
                    }
                    if (phase % threadCount == threadId) { // 按照phase顺序执行
                        System.out.println("Thread-" + threadId + ": " + counter++);
                    }
                }
            }).start();
        }
    }

}
