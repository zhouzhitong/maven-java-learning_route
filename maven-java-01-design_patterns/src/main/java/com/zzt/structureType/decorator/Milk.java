package com.zzt.structureType.decorator;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 7:51
 **/
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setPrice(2.0F);
        setDes("牛奶");
    }

}
