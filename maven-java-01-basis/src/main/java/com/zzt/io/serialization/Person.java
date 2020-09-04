package com.zzt.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 描述：<br> 序列化机制：2. Externalizable
 *      1. 关键字：transient，在此处没有任何效果。
 *      2. 通过无参构造器创建对象，因此 对象中，必须存在一个无参构造
 *      3. writeExternal、readExternal 分别实现 序列化操作和反序列化操作。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/3 14:42
 */
public class Person implements Externalizable {

    private static final long serialVersionUID = 1L;
    private transient Long id;
    private String name;
    private transient Integer age;
    private String remarks;

    public Person() {
        System.out.println("构造器");
        this.age = 23;
    }

    public Person(Long id, String name, String remarks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remarks = remarks;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(remarks);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 要与 writeExternal 写入的顺序一致
        id = (Long) in.readObject();
        name = (String) in.readObject();
        age = (Integer) in.readObject();
        remarks = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
