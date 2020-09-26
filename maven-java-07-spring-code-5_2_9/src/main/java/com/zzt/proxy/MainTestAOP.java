package com.zzt.proxy;

import com.zzt.proxy.impl.CalculatorImpl;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 17:10
 */
public class MainTestAOP {

    public static void main(String[] args) {
        CalculatorProxy calculatorProxy = new CalculatorProxy();
        Calculator calculator = (Calculator) calculatorProxy.getProxy(CalculatorImpl.class);
        calculator.doAdd(1,23);

    }

}
