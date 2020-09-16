package com.zzt.multithread.api;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/16 14:53
 */
public class ThreadApiDemo01 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        Thread t1 = new Thread(myThread1);
        // NEW状态
//        System.out.println(t1.getState().name());
        Thread t2 = new Thread(myThread1);
        t1.start();
        t2.start();
        // 获取状态
        /*for (int i = 0; i <10 ; i++) {
            System.out.println(t1.getName()+" -- "+t1.getState().name());
            System.out.println(t2.getName()+t2.getState().name());
            Thread.sleep(1000);
        }*/

    }


    private static class MyThread implements Runnable {
        private static final Object o = new Object();

        private MyThread() {
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                synchronized (o) {
//                    o.notifyAll();
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始！！！");
                        Thread.sleep(1000);
                        reentryLock();
//                        o.wait();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "结束！！！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void reentryLock() throws InterruptedException {
            synchronized (o){
                Thread.sleep(900);
                System.out.println("可重入锁！！！");
            }
        }

    }

}
