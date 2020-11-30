package com.zzt.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/14 8:32
 **/
public class ListDemo02 {

    public static void main(String[] args) {
        Info info;
        List<Info> list = new ArrayList<>();

        info = new Info("张三", 21);
        list.add(info);

        info = new Info("李四", 21);
        list.add(info);

        info = new Info("李四", 23);
        list.add(info);

        info = new Info("李四", 21);
        list.add(info);

        /*for (Info info1 : list) {
            System.out.println(info1);
        }*/

        System.out.println(list.remove(info));
        System.out.println(list.remove(info));
        System.out.println(list.remove(info));

        for (Info info1 : list) {
            System.out.println(info1);
        }
    }
}

class Info {

    String name;
    Integer age;

    public Info(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Info info = (Info) o;

        if (!Objects.equals(name, info.name)) {
            return false;
        }
        return Objects.equals(age, info.age);
    }

    /*@Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}