package com.zzt.structureType.decorator;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 7:50
 **/
public class ShortCoffee extends Coffee {

    public ShortCoffee(float price) {
        setDes("shortCoffee " + price);
        setPrice(price);
    }

}
