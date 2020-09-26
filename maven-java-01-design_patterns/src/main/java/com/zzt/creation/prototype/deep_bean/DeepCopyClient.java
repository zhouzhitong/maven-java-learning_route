package com.zzt.creation.prototype.deep_bean;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>客户端： --> 深拷贝
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 21:36
 **/
public class DeepCopyClient {
    private Sheep sheep = new Sheep("被克隆羊", 3, "黑色");

    @Test
    public void test01DeepCopyClient(){
        Sheep cloneSheep = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(cloneSheep);
        System.out.println("============================");
        sheep.setName("修改的羊");
        System.out.println(sheep);
        System.out.println(cloneSheep);
    }

    private Person person = new Person("张三", 21, "江西", sheep);

    @Test
    public void test02(){
        Person clonePerson = (Person) person.clone();
        System.out.println(person);
        System.out.println(clonePerson);
        System.out.println("==============================");
        person.setName("李四");
        sheep.setName("被修改羊");
        System.out.println(person);
        System.out.println(clonePerson);
    }

}
