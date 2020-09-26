package com.zzt.proxy;

import com.zzt.proxy.impl.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 17:03
 */
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
        before();
        Object invoke = method.invoke(impl, args);
        after();
        return invoke;
    }

    //可以重写
    public void before() {
        System.out.println("之后");
    }

    public void after() {
        System.out.println("之后");
    }
}
