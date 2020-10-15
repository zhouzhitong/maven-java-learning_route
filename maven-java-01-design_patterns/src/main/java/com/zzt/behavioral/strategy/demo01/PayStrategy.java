package com.zzt.behavioral.strategy.demo01;

/**
 * 描述：<br> Common interface for all strategies.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 11:51
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}