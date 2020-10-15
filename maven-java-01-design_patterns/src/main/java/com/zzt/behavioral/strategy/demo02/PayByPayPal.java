package com.zzt.behavioral.strategy.demo02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 15:46
 */
public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private AlipayUser user;
    private boolean signedIn = false;

    static {
        DATA_BASE.put("root", "123456");
        DATA_BASE.put("guest", "123456");
    }

    public PayByPayPal() {
        user = new AlipayUser();
    }

    @Override
    public void collectPaymentDetails() {
        while (!signedIn) {
            try {
                System.out.println("请输入用户名：");
                user.setUsername(reader.readLine());
                System.out.println("请输入密码：");
                user.setPassword(reader.readLine());
                if (verify()) {
                    System.out.println("输入信息正确！！！");
                } else {
                    System.out.println("输入的信息有误，请重新输入： ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean verify() {
        setSignedIn(user.getPassword()
                .equals(
                        DATA_BASE.get(user.getUsername())));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    @Override
    public boolean isPay(Double totalCost) {
        if (signedIn) {
            System.out.println("Paying " + totalCost + " using PayPal.");
            return true;
        } else {

            return false;
        }
    }
}
