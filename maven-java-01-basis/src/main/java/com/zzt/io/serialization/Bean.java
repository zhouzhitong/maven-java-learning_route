package com.zzt.io.serialization;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：<br>1. Serialization：
 *      1. serialVersionUID的作用是，验证 版本号【在JVM底层实现】。当不同时，会出现异常信息：InvalidCastException
 *      2. transient 关键字：让其修饰的属性，不能序列化。
 *      3. 在JVM层面上实现对象的创建
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/3 14:25
 */
public class Bean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private transient Date birthday;    // 不被序列化

    public Bean() {
        System.out.println("构造器");
    }

    public Bean(Long id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}