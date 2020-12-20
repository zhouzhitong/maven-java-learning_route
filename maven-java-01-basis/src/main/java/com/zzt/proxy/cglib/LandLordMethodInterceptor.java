package com.zzt.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/20 20:24 **/
public class LandLordMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("中介：正在寻找房源==========");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("中介：该房源已发布==========");
        return obj;
    }
}
