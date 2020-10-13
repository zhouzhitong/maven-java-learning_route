package com.zzt.behavioral.observer.demo01;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/13 0:15
 **/
public class Client {

    public static void main(String[] args) {

        EventManager manager = new EventManager();
        EventListener listener;
        listener = new LoggingListener(1);
        manager.subscribe(listener);
        listener = new LoggingListener(2);
        manager.subscribe(listener);
        listener = new LoggingListener(3);
        manager.subscribe(listener);

        listener = new EmailAlterListener(1);
        manager.subscribe(listener);

        manager.notify("C:\\abc");

    }

}
