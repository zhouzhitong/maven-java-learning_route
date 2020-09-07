package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 11:53
 */
public class LongCoffee extends Coffee {

    public LongCoffee() {
        setPrice(7.8f);
        setDes("long_black咖啡~~~");
    }

    public LongCoffee(float price, String des) {
        super(price, des);
    }
}
