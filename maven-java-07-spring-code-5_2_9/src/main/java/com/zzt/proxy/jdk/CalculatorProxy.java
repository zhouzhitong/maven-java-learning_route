package com.zzt.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/9/26 17:03 */
public class CalculatorProxy implements InvocationHandler {

    Object impl;

    public <T> Object getProxy(Class<T> clz) {
        try {
            impl = clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // 生成动态代理
        return Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy, method, args);
        Object invoke = method.invoke(impl, args);
        after(proxy, method, args);
        return invoke;
    }

    //可以重写
    public void before(Object proxy, Method method, Object[] args) {
        Logger.before(method);
    }

    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("之后");
    }
}
