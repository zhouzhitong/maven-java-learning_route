package com.zzt.tx.propagation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        BookService mulService = context.getBean(BookService.class);
        mulService.mulTx();
        /*ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();*/
    }

}