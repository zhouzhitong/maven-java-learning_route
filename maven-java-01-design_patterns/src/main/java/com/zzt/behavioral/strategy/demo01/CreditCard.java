package com.zzt.behavioral.strategy.demo01;

/**
 * 描述：<br>Dummy credit card class.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 11:54
 */
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
