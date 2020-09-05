package com.zzt.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：<br> 案例：三个人(三个线程)，各买100张票，放进一个篮子里（同一个TicketThread对象）
 *      需求：统计三个人买的票数（理论上应该是300张）
 * 结论：
 *      1. AtomicInteger 保证了加减操作的原子性，保证了不会重复操作的情况发生。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 21:53
 **/
public class AtomicDemo01 {

    public static void main(String[] args) throws InterruptedException {
        TicketThread ticketThread = new TicketThread();
        Thread thread1 = new Thread(ticketThread);
        Thread thread2 = new Thread(ticketThread);
        Thread thread3 = new Thread(ticketThread);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("共买的票数：-->" + ticketThread.tickets.get());
    }
}

/**
 * 需求：三个人(三个线程)，各买100张票
 */
class TicketThread implements Runnable {
    public AtomicInteger tickets = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            tickets.getAndIncrement();
        }
    }
}