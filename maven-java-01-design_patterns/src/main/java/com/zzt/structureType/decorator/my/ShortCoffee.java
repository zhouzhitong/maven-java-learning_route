package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 11:52
 */
public class ShortCoffee extends Coffee {

    public ShortCoffee(){
        setPrice(5.9F);
        setDes("短咖啡~~~");
    }

    public ShortCoffee(float price, String des) {
        super(price, des);
    }

}
