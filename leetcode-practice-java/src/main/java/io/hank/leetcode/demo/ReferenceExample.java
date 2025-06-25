package io.hank.leetcode.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceExample {

    public static void main(String[] args) {
        // 强引用
        Object obj = new Object(); // 创建强引用
        System.out.println("Before GC: " + obj);

        obj = null; // 移除强引用
        System.gc(); // 建议 JVM 进行垃圾回收

        // 此时 obj 已经被回收
        System.out.println("After GC: " + obj);

        // 软引用
        obj = new Object();
        SoftReference<Object> softRef = new SoftReference<>(obj); // 创建软引用

        System.out.println("Before GC: " + softRef.get());

        obj = null; // 移除强引用
        System.gc(); // 建议 JVM 进行垃圾回收

        // 如果内存充足，软引用对象可能仍然存在
        System.out.println("After GC: " + softRef.get());

        // 弱引用
        obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj); // 创建弱引用

        System.out.println("Before GC: " + weakRef.get());

        obj = null; // 移除强引用
        System.gc(); // 建议 JVM 进行垃圾回收

        // 弱引用对象通常会被立即回收
        System.out.println("After GC: " + weakRef.get());

        // 虚引用
        obj = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>(); // 创建引用队列
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, queue); // 创建虚引用

        System.out.println("Before GC: " + phantomRef.get()); // get() 总是返回 null

        obj = null; // 移除强引用
        System.gc(); // 建议 JVM 进行垃圾回收

        // 检查引用队列中是否有被回收的对象
        System.out.println("After GC: " + queue.poll());
    }
}
