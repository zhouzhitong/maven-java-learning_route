package com.test;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/8 21:07
 **/
public class HeroDemo01 {

    public static void main(String[] args) {

        Hero hero = new Hero();

//        // 创建对象 Hero1
//        Hero hero1 = new Hero();
//        hero1.name = "鲁班";
//        hero1.hp = 1000.5F;
//        hero1.armor = 412.90F;
//        // 使用刚才创建好的对象
//        System.out.println("对象 hero1 的姓名："+hero1.name);// 打印 对象 hero1 的   姓名 name 属性
//        System.out.println("对象 hero1 的血量："+hero1.hp);// 打印 对象 hero1 的     血量 hp 属性
//        System.out.println("对象 hero1 的护甲值："+hero1.armor);// 打印 对象 hero1 的  护甲 armor 属性
//        String s = hero1.toString();    // 调用 对象 hero1 的 toString() 方法
//        System.out.println("对象hero1 的 toString()方法的返回值： -- "+s);
    }

    public static void pdsf(Hero n1,Hero n2){
    }

}

class Person{
    String name;
    int age;
    boolean isHandsome;
    boolean isHeight;

}

/**
 * 定义类： Hero
 */
class Hero {
    String name;// 英雄人物名称
    float hp;// 剩余血量
    float armor;// 护甲值
    public Hero() {
    }
    public Hero(String n, float h, float a) {
        name = n;
        hp = h;
        armor = a;
    }
    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", armor=" + armor +
                '}';
    }
}