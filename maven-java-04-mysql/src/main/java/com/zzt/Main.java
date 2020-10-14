package com.zzt;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/14 17:07
 */
public class Main {

    private static String url="jdbc:mysql://47.94.175.132:3306/blog";
    private static String username="root";
    private static String password="123456";

    public static void main(String[] args) {
        String classDriver = "com.mysql.jdbc.Driver";
        Connection connection;
        try {
            Class.forName(classDriver);
            connection = DriverManager.getConnection(url,username,password);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
