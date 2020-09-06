package com.zzt.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/6 10:22
 **/
public class ReentrantLockDemo01 {

    public static void main(String[] args) throws InterruptedException {
        LockThread lockThread = new LockThread();
        Thread thread1 = new Thread(lockThread);
        Thread thread2 = new Thread(lockThread);
        Thread thread3 = new Thread(lockThread);
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(lockThread.count);
    }

    private static class LockThread implements Runnable {
        Integer count = 0;
        private Lock lock = new ReentrantLock();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}



