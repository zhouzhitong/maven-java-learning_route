package com.zzt.behavioral.strategy.demo02;

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
 * @date 2020/10/15 16:19
 */
public class Demo {

    private final static Map<Integer, Double> COMMODITY = new HashMap<>();

    static {
        COMMODITY.put(1, 5.0);
        COMMODITY.put(2, 2999.6);
        COMMODITY.put(3, 5099.9);
        COMMODITY.put(4, 2199.1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        Order order = new Order();
        PayStrategy strategy;
        while (!order.isClosed()) {
            double cost = 0.0;
            do {
                String commodity = "1 - 苹果  "+ COMMODITY.get(1) +"\n"
                        + "2 - 手机  "+ COMMODITY.get(2) +"\n"
                        + "3 - 电脑  "+ COMMODITY.get(3) +"\n"
                        + "4 - IPay  "+ COMMODITY.get(4) +"\n";
                System.out.println("请选择商品：");
                System.out.println(commodity);
                Double selectOne = COMMODITY.get(Integer.parseInt(reader.readLine()));
                System.out.println("请输入你需要购买的数量：");
                Integer selectCount = Integer.parseInt(reader.readLine());
                // 获取总价格
                cost += selectCount*selectOne;
                order.setTotalCost(cost);
                System.out.println("是否继续购买商品");
            }while ("y".equalsIgnoreCase(reader.readLine().trim()));

            System.out.println("选择支付方式:  \n1. 支付宝：");


            strategy = new PayByPayPal();
//            if ("1".equals(reader.readLine())){
//            strategy = new PayByPayPal();
//            }
            order.processOrder(strategy);

            System.out.println("是否继续购买商品？Y/N");
            if ("N".equalsIgnoreCase(reader.readLine())){

                if (strategy.isPay(order.getTotalCost())){
                    System.out.println("Payment has been successful.");
                }else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed(true);
            }
        }


    }

}
