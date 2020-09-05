package com.zzt.multithread.threadLocal;

/**
 * 描述：<br>案例：银行的转账业务。
 * 需求：银行现在有一个用户同时在向两个账户转账。
 * 代码测试结果：
 * 两个线程之间的结果没有任何影响
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 17:23
 **/
public class ThreadLocalDemo01 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankThread bankThread = new BankThread(bank);
        Thread thread1 = new Thread(bankThread, "Thread-1");
        Thread thread2 = new Thread(bankThread, "Thread-2");

        thread1.start();
        thread2.start();
        /*
        运行结果：
            Thread-0 10
            Thread-0 20
            Thread-0 30
            Thread-1 10
            Thread-1 20
            Thread-1 30
        */
    }
}

/**
 * 案例：银行的转账业务。
 * 需求：银行现在有一个用户同时在向两个账户转账。
 */
class Bank {
    ThreadLocal<Integer> t = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer get() {
        return t.get();
    }

    public void set() {
        t.set(t.get() + 10);
    }

}

class BankThread implements Runnable {
    private Bank bank;

    public BankThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            bank.set();
            System.out.println(Thread.currentThread().getName() + " " + bank.get());
        }
    }
}
