package com.zzt.creation.prototype.shallow_bean;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 21:36
 **/
public class ShallowCopyClient {

    private Sheep sheep = new Sheep("被克隆羊", 3, "黑色");

    @Test
    public void test01ShallowCopy() {
        Sheep cloneSheep1 = (Sheep) sheep.clone();
        System.out.println(sheep);
        sheep.setAge(4);
        System.out.println(sheep);
        System.out.println("================================");
        System.out.println(cloneSheep1);
    }

    private Person person = new Person("张三", 21, "江西", sheep);
    @Test
    public void test02ShallowCopy() {
        Person clonePerson = (Person) person.clone();
        System.out.println(person);
        person.setName("李四");
        System.out.println(person);
        System.out.println(clonePerson);
        System.out.println("================================");
        sheep.setAge(4);    // 被克隆出来的对象，值也被修改了
        System.out.println(person); // Person{name='李四', age=21, address='江西', sheep=Sheep{name='被克隆羊', age=4, color='黑色'}}
        System.out.println(clonePerson); // Person{name='张三', age=21, address='江西', sheep=Sheep{name='被克隆羊', age=4, color='黑色'}}
    }

}
