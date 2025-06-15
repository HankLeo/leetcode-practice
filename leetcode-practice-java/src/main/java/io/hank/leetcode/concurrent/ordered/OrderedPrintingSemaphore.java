package io.hank.leetcode.concurrent.ordered;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 每个线程各检查1个不同的信号量，每个信号量也只允许线程执行一次，通过信号量依次唤醒下一个线程
 * 写法比ReentrantLock更简洁，因为不需要显式地获取和释放锁
 */
public class OrderedPrintingSemaphore {
    private static int counter = 1;
    private static final int MAX = 100;
    private static final Semaphore[] semaphores;
    private static final int THREAD_COUNT = 3;

    static {
        semaphores = new Semaphore[THREAD_COUNT];
        semaphores[0] = new Semaphore(1); // 第一个线程先执行
        for (int i = 1; i < THREAD_COUNT; i++) {
            semaphores[i] = new Semaphore(0);
        }
    }

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT)) { // try-with-resources自动终止线程池
            // 启动线程
            for (int i = 0; i < THREAD_COUNT; i++) {
                final int threadId = i; // 线程ID等于信号量数组的索引
                executorService.submit(() -> {
                    while (counter <= MAX) {
                        try {
                            semaphores[threadId].acquire(1); // 等待当前线程信号量
                            if (counter <= MAX) {
                                System.out.println(STR."Thread-\{threadId}: \{counter++}");
                            }
                            semaphores[(threadId + 1) % THREAD_COUNT].release(1); // 指定释放下一个线程的信号量
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
            }
        }
    }

}
