package com.zzt.behavioral.strategy.demo02;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 15:41
 */
public interface PayStrategy {

    /**
     * 收集需要支付的信息
     */
    void collectPaymentDetails();

    /**
     * 判断是否完成支付
     * @param totalCost 核对 需要支付的金额
     * @return
     */
    boolean isPay(Double totalCost);

}
