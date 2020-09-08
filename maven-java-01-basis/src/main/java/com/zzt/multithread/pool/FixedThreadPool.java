package com.zzt.multithread.pool;

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
 * @date 2020/9/7 17:04
 */
public class FixedThreadPool {

    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.shutdown();
    }

    private static class MyRunnable implements Runnable {
        private Lock lock = new ReentrantLock();
        private Integer count = 0;

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    lock.lock();
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " -- " + count++);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(" ================= ");
        }
    }
}
