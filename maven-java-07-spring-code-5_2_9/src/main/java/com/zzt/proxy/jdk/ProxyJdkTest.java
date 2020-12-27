package com.zzt.proxy.jdk;

import com.zzt.proxy.jdk.impl.CalculatorImpl;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 22:38 **/
public class ProxyJdkTest {

    public static void main(String[] args) {
        CalculatorProxy calculatorProxy = new CalculatorProxy();
        Calculator calculator = (Calculator) calculatorProxy.getProxy(CalculatorImpl.class);
        calculator.doAdd(1, 23);
    }

}
