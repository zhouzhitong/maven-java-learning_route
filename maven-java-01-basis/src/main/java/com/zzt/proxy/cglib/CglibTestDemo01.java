package com.zzt.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/20 20:26 **/
public class CglibTestDemo01 {

    public static void main(String[] args) {

        // 动态代理创建的 class 文件存储到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");

        LandLordMethodInterceptor interceptor = new LandLordMethodInterceptor();
        // 通过 cglib 动态代理获取代理对象的过程，创建调用的对象
        Enhancer enhancer = new Enhancer();
        // 设置 enhancer 对象的父类
        enhancer.setSuperclass(LandLord.class);
        // 设置 enhancer 的回调对象
        enhancer.setCallback(interceptor);
        // 创建代理对象
        LandLord landLord = (LandLord) enhancer.create();
        landLord.rent();
    }

}
