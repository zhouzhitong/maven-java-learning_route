package com.zzt.multithread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 11:06
 */
public class CallableDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main主线程正在执行：" + new Date().getTime());
        }
        if (!task.isDone()) {
            task.cancel(true);
//            task.cancel(false);
        }
        System.out.println(task.isCancelled()?task.get():"被取消了~~~");
    }
    private static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("MyCallable正在执行：" + new Date().getTime());
            }
            return "MyCallable执行完毕！";
        }
    }
}



