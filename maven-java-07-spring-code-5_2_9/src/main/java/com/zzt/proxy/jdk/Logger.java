package com.zzt.proxy.jdk;

import java.lang.reflect.Method;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 17:03
 */
public class Logger {

    public static void before(Method method){
        System.out.println(method.getName());
    }

}
