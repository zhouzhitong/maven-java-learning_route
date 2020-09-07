package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 13:22
 */
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setPrice(4.0F);
        setDes(" + 豆浆 <" + 4.0f + ">");
    }
}
