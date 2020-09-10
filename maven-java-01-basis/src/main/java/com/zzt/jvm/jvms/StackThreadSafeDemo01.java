package com.zzt.jvm.jvms;

import java.util.Random;

/**
 * 描述：<br> 判断栈帧中的 变量是否安全？
 * 问题背景：
 * <p>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/10 14:30
 */
public class StackThreadSafeDemo01 {

    public static void main(String[] args) throws InterruptedException {
//        stackThreadSafeTest01();
        stackThreadSafeTest02();
    }


    private static void stackThreadSafeTest01() {
        new Thread(SafeDemo01::method01).start();
        new Thread(SafeDemo01::method01).start();
    }

    private static void stackThreadSafeTest02() throws InterruptedException {
        new Thread(SafeDemo01::method02).start();
        Thread.sleep(100);
        new Thread(SafeDemo01::method02).start();
    }

    private static class SafeDemo01 {
        // volatile
        private static int count;

        private static void method01() {
            try {
                int i = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + " 1 " + i);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 2 " + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void method02() {
            try {
                count = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + " 1 " + count);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 2 " + count);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
