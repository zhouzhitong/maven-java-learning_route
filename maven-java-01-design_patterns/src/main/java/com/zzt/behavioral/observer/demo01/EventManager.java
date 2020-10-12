package com.zzt.behavioral.observer.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/13 0:02
 **/
public class EventManager {
    private List<EventListener> listeners;

    public EventManager() {
        listeners = new ArrayList<>();
    }

    public void subscribe(EventListener listener){
        listeners.add(listener);
    }

    public void notify(String data){
        for (EventListener listener : listeners) {
            listener.update(data);
        }
    }

}
