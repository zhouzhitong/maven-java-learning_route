package com.zzt.creation.prototype.deep_bean;

import java.io.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 21:19
 **/
public class Person implements Serializable, Cloneable {
    private String name;
    private Integer age;
    private String address;
    private Sheep sheep;

    public Person() {
        System.out.println("调用了无参构造");
    }

    public Person(String name, Integer age, String address, Sheep sheep) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sheep = sheep;
    }

    @Override
    public Object clone() {
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
