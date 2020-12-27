package com.mashibing;

import com.mashibing.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 描述：<br>
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/27 17:58 **/
public class AutomaticBeansDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("automaticBeans.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person.toString());
    }
}
