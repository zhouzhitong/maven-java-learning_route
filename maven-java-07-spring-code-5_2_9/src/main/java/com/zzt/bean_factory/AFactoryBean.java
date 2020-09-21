package com.zzt.bean_factory;

import com.zzt.bean.A;
import org.springframework.beans.factory.FactoryBean;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 0:02
 **/
public class AFactoryBean implements FactoryBean<A> {

    private A a;

    public AFactoryBean(String name, Integer age) {
        this.a = new A();
        this.a.setName(name);
        this.a.setAge(age);
    }

    @Override
    public A getObject() throws Exception {
        System.out.println("执行了 A 的 Bean 工厂");
        return a;
    }

    @Override
    public Class<?> getObjectType() {
        return A.class;
    }
}
