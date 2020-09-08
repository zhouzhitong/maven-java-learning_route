package com.zzt.multithread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 16:55
 */
public class CachedThreadPoolDemo01 {
    private static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        newCachedThreadPool.execute(runnable);
        newCachedThreadPool.execute(runnable);
        newCachedThreadPool.shutdown();
        System.out.println("main：" + runnable.count);

    }
    private static class MyRunnable implements Runnable {
        private Lock lock = new ReentrantLock();
        private Integer count = 0;
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    lock.lock();
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + " -- " + count);
        }
    }
}
