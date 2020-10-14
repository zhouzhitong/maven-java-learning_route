package com.zzt.behavioral.observer.demo02;

import java.io.File;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/14 12:59
 */
public interface EventListener {
    void update(String eventType, File file);
}
