package com.zzt.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/20 20:14 **/
public class JdkTestDemo01 {

    public static void main(String[] args) throws Throwable {
        Rent rent = new RentImpl();
        RentJdkInvocationHandler handler = new RentJdkInvocationHandler(rent);
//        handler.invoke(rent, rent.getClass().getMethod("rent"), null);
        System.out.println("\n==========================\n");
        rent = (Rent) Proxy.newProxyInstance(rent.getClass().getClassLoader(), rent.getClass().getInterfaces(), handler);
        rent.rent();
    }

}
