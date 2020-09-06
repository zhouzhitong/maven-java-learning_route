package com.zzt.multithread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/6 20:11
 **/
public class ReadAndWriteLockDemo01 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread(1);
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

    }

    private static class MyThread implements Runnable {
        private Map<Integer, String> map;
        private Lock readLock;
        private Lock writeLock;
        private Integer type;

        public MyThread(Integer type) {
            map = new HashMap<>();
            map.put(1, "hello");
            map.put(2, " world");
            ReadWriteLock rw = new ReentrantReadWriteLock();
            readLock = rw.readLock();
            writeLock = rw.writeLock();
            this.type = type;
        }
        @Override
        public void run() {
            switch (type) {
                case 1: {
                    type++;
                    // 写锁：执行写操作+读操作
                    try {
                        writeLock.lock();
                        System.out.println(Thread.currentThread().getName() + " 开始进行写操作~~~~");
                        Thread.sleep(5 * 1000);
                        System.out.println("休眠结束。。。");
                        map.put(3, "!!!");
                        System.out.println("写操作完成~~~开始测试");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        writeLock.unlock();
                    }
                    break;
                }
                case 2: {
                    type--;
                    try {
                        writeLock.lock();
                        System.out.println("开始读操作！！！");
                        Thread.sleep(1000);
                        System.out.println("读取得到的值：-->" + map.get(2));
                        Thread.sleep(10 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        writeLock.unlock();
                    }
                }
            }
        }
    }
}
