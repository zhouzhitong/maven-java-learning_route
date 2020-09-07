package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 11:57
 */
public class Decorator implements Drink {

    private Drink drink;
    private String des;
    private float price;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return drink.cost() + getPrice();
    }

    @Override
    public String getDes() {
        return drink.getDes() + " " + des ;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public void setPrice(float price) {
        this.price =drink.getPrice()+ price;
    }
}
