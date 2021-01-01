package com.zzt.pool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 描述：<br>
 参考官网：https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98
 </>
 @author 周志通
 @version 1.0.0
 @date 2021/1/1 9:49 **/
public class DruidTest {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("D:\\work-room\\maven-java-learning_route\\maven-java-04-mysql\\src\\main\\java\\com\\zzt\\pool\\druid\\druid.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
