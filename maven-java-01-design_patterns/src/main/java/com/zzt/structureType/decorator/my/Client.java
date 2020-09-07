package com.zzt.structureType.decorator.my;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 11:53
 */
public class Client {

    public static void main(String[] args) {
//        Drink drink = new ShortCoffee();
        Drink drink = new LongCoffee();

        System.out.println("价格：--> " + drink.getPrice());
        System.out.println("描述：--> " + drink.getDes());

        System.out.println(" ========================== ");

        drink = new Milk(drink);
        System.out.println("价格：--> " + drink.getPrice());
        System.out.println("描述：--> " + drink.getDes());
        drink = new Milk(drink);
        System.out.println("价格：--> " + drink.getPrice());
        System.out.println("描述：--> " + drink.getDes());

        drink = new Soy(drink);
        System.out.println("价格：--> " + drink.getPrice());
        System.out.println("描述：--> " + drink.getDes());
    }

}
