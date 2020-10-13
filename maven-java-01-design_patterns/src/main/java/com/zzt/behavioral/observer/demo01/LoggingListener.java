package com.zzt.behavioral.observer.demo01;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/12 23:44
 **/
public class LoggingListener implements EventListener {
    private Integer id;

    public LoggingListener(Integer id) {
        this();
        this.id = id;
    }

    public LoggingListener() {
    }

    @Override
    public void update(String fileName) {
        System.out.println("Logging -- > " + id + " -- " + fileName);
    }
}
