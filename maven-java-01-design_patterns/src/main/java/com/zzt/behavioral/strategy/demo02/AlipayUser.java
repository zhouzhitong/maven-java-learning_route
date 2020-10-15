package com.zzt.behavioral.strategy.demo02;

import java.util.Random;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 15:49
 */
public class AlipayUser {

    private String username;

    private String password;

    private Double money;

    public AlipayUser() {
        this.money = new Random().nextDouble();
    }

    public AlipayUser(String username, String password, Double money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
