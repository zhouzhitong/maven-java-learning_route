package com.zzt.multithread;

/**
 * 描述：<br>
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 10:16
 */
public class RunnableTestDemo01 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
        t3.start();
    }
    private static class MyRunnable implements Runnable{

        //    private static volatile Integer count = 0;
        private static Integer count = 0;

        public MyRunnable(){
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("执行次数：--> " + i + "（剩余次数：--> " + (++count) + "）");
            }
        }
    }

}

