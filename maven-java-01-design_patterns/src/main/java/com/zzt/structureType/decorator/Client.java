package com.zzt.structureType.decorator;

/**
 * 描述：<br> 具体说明：https://blog.csdn.net/First_Bal/article/details/108028530
 * 总结：1. 从实践中看,不建议将 Drink 定义为 接口。
 *       2. 在使用过程中，由于会频繁的切换父子类的实体，因此需要注意
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 7:52
 **/
public class Client {

    public static void main(String[] args) {

        Drink drink = new ShortCoffee(5);
        System.out.println(drink.getDes());
        System.out.println(drink.getPrice());
        System.out.println(drink.cost());

        System.out.println("==========================");
        drink = new Milk(drink);
        System.out.println(drink.getDes());
        System.out.println(drink.getPrice());
        System.out.println(drink.cost());
//        drink = new Milk(drink);
//        System.out.println(drink.getDes());
//        System.out.println(drink.getPrice());
//        System.out.println(drink.cost());
    }

}
