package com.zzt.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/20 20:12 **/
public class RentJdkInvocationHandler implements InvocationHandler {

    private Object post;

    public RentJdkInvocationHandler(Object post) {
        this.post = post;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介：正在找房源");
        Object invoke = method.invoke(post, args);
        System.out.println("中介：该房源已发布！");
        return invoke;
    }
}
