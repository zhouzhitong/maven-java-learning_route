package com.zzt.aop.bean;

import org.springframework.stereotype.Component;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 23:09 **/
@Component
public class Person {

    private String name;

    private String address;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
