package com.zzt.mysql.tran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class TranSqlTest02 {

    private static String url = "jdbc:mysql://47.94.175.132:3306/tran";
    private static String username = "root";
    private static String password = "123456";

    public static void main(String[] args) {
        String classDriver = "com.mysql.jdbc.Driver";
        Connection connection = null;
        try {
            Class.forName(classDriver);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String sql = "delete from psn where id = 2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
