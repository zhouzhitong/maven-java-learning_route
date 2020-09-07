package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 12:00
 */
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setPrice(2.5F);
        setDes(" + 牛奶<" + 2.5F + ">");
    }
}
