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

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            lock.lock();
        }
        System.out.println("1");
        for (int i = 0; i < 2; i++) {
            lock.unlock();
        }
        System.out.println("2");

    }

}
