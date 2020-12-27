package com.zzt.proxy.jdk.impl;

import com.zzt.proxy.jdk.Calculator;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 17:06
 */
public class CalculatorImpl implements Calculator {

    @Override
    public void doAdd(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}
