package com.zzt.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/6 11:01
 **/
public class AtomicIntegerArrayDemo01 {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(myThread.atomicIntegerArray.toString());

    }

    private static class MyThread implements Runnable {

        private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(3);

        @Override
        public void run() {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    atomicIntegerArray.getAndIncrement(i);
                }
            }

        }
    }

}
