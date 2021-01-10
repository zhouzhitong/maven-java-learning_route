package com.zzt.tx;

import com.zzt.tx.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TxTest01 {

    ApplicationContext ac = new ClassPathXmlApplicationContext("txBeans.xml");

    @Test
    public void test02() throws FileNotFoundException {
        BookService bean = ac.getBean(BookService.class);
        bean.checkout("lisi", 1);
        ((ClassPathXmlApplicationContext) ac).close();
    }

    @Test
    public void test01() {
        DruidDataSource bean = ac.getBean(DruidDataSource.class);
        try {
            System.out.println(bean.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
