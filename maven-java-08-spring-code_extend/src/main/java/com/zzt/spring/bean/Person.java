package com.zzt.spring.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 描述：<br>
 获取构造器集合
 1. 如果有多个Autowired，required为true，不管有没有默认构造方法，会报异常
 2. 如果只有一个Autowired，required为false，没有默认构造方法，会报警告
 3. 如果没有Autowired注解，定义了两个及以上有参数的构造方法，没有无参构造方法，<b>且通过注解注入的</>，就会报错
 补充：通过 @注解 注入的Bean，在有 @Autowired 注解时，没有无惨构造方法，也会报错
 4. 其他情况都可以，但是以有Autowired的构造方法优先，然后才是默认构造方法
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/6 20:16 **/
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@DependsOn(value = {"user"})
public class Person {

    private String name;
    private Integer age;
    /*public Person() {
    }*/

    @Autowired
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(Integer age, String name) {
        this.name = name;
        this.age = age;
    }

    public Person(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

}
