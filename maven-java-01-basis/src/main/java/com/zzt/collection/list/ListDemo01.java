package com.zzt.collection.list;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 9:42
 */
public class ListDemo01 {

    public static void main(String[] args) throws InterruptedException {
        arrayListTest01();
//        vectorTest02();
//        linkedListTest03();
    }

    private static void arrayListTest01() throws InterruptedException {
        ArrayListThread runnable = new ArrayListThread(new ArrayList<>());
        threadTest(runnable);


    }
    private static void vectorTest02() throws InterruptedException {
        ArrayListThread runnable = new ArrayListThread(new ArrayList<>());
        threadTest(runnable);
    }

    private static void linkedListTest03() throws InterruptedException {
        ArrayListThread runnable = new ArrayListThread(new LinkedList<>());
        threadTest(runnable);
    }


    private static void threadTest(ArrayListThread runnable) throws InterruptedException {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("集合大小：-->" + runnable.list.size());
        System.out.println("集合内容：-->" + runnable.list);
    }

    private static class ArrayListThread implements Runnable {

        private List<Integer> list;

        public ArrayListThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            // 向集合添加数据
            try {

                for (int i = 0; i < 100; i++) {
                    list.add(new Random().nextInt());
                    Thread.sleep(10);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
