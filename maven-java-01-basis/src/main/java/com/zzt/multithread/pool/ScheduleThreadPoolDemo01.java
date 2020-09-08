package com.zzt.multithread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 17:12
 */
public class ScheduleThreadPoolDemo01 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            scheduledThreadPool.schedule(() -> System.out.println(Thread.currentThread().getName()+" delay 3 seconds"), 1, TimeUnit.SECONDS);
            Thread.sleep(1500);
        }
        scheduledThreadPool.shutdown();
    }
}
