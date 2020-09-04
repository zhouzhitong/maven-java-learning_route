package com.zzt.multithread;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 10:04
 */
public class ThreadTestDemo01 {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.start();
        t2.start();
        t3.start();

    }

}

class MyThread extends Thread {
    //    private static volatile Integer count = 0;
    private static Integer count = 0;

    public MyThread() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("执行次数：--> " + i + "（剩余次数：--> " + (++count) + "）");
        }
    }
}