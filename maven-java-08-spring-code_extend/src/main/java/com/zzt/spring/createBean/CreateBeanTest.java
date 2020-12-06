package com.zzt.spring.createBean;

import com.zzt.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/3 15:14
 */
public class CreateBeanTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/autowiredBean.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        person = ac.getBean("person", Person.class);
        System.out.println(person);
    }

}
