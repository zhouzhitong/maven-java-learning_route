package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 11:48
 */
public class Coffee implements Drink {
    private String des;
    private float price;

    public Coffee() {
    }

    public Coffee(float price, String des) {
        setPrice(price);
        setDes(des);
    }


    @Override
    public float cost() {
        return getPrice();
    }

    @Override
    public String getDes() {
        return des;
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
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
}
