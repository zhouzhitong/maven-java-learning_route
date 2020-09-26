package com.zzt.creation.prototype.shallow_bean;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 21:19
 **/
public class Person implements Cloneable{
    private String name ;
    private Integer age;
    private String address;
    private Sheep sheep;

    public Person(String name, Integer age, String address, Sheep sheep) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sheep = sheep;
    }

    @Override
    public Object clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sheep=" + sheep +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
