package com.zzt.multithread.pool;

import lombok.SneakyThrows;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 10:29
 */
public class ThreadPoolManageDemo01 {

    public static void main(String[] args) {
        //1.使用Executors创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);    // 创建一个固定大小的线程池
        //2.通过线程池执行线程
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable());
        }
        //3.主线程循环打印
        for (int i = 0; i < 10; i++) {
            System.out.println("main主线程正在执行：" + new Date().getTime());
        }
        // 4. 关闭线程池
        executorService.shutdown();
    }

}

class MyRunnable implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "线程正在执行：" + new Date().getTime());
        }
    }
}
