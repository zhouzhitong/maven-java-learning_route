package com.zzt.structureType.decorator;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 7:49
 **/
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
