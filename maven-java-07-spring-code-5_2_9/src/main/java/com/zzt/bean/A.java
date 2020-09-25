package com.zzt.bean;

import org.springframework.stereotype.Component;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 8:40
 **/
//@Component
public class A {

    private String name;
    private Integer age;
    private B b;
    public A() {
    }

    public A(String name, Integer age,B b) {
        this.name = name;
        this.age = age;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
