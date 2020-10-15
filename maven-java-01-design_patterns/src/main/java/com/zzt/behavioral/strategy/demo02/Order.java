package com.zzt.behavioral.strategy.demo02;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 16:16
 */
public class Order {

    private Double totalCost = 0.0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy) {
        payStrategy.collectPaymentDetails();
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost += totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
