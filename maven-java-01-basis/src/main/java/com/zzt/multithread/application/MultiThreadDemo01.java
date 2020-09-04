package com.zzt.multithread.application;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 11:56
 */
public class MultiThreadDemo01 {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable, "窗口1");
        Thread t2 = new Thread(runnable, "窗口2");
        Thread t3 = new Thread(runnable, "窗口3");

        t1.start();
        t2.start();
        t3.start();


    }

    private static class MyRunnable implements Runnable {

        private volatile Integer ticket = 100;

        @Override
        public synchronized void run() {
            /*while (true) {
                if (ticket > 0) {
                    //1.模拟出票时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //2.打印进程号和票号，票数减1
                    String name = Thread.currentThread().getName();
                    System.out.println("线程" + name + "售票：" + ticket--);
                } else {
                    break;
                }
            }*/
            while (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName()
                        + " 正在售票--> 此时剩余票数：" + (--ticket));
            }

        }
    }

}


