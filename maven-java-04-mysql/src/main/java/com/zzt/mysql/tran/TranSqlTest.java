package com.zzt.mysql.tran;

import java.sql.*;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class TranSqlTest {

    private static String url = "jdbc:mysql://47.94.175.132:3306/tran";
    private static String username = "root";
    private static String password = "123456";

    public static void main(String[] args) throws SQLException {
        String classDriver = "com.mysql.jdbc.Driver";
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            Class.forName(classDriver);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);    // 关闭自动提交
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            savepoint = connection.setSavepoint("abc");
            String sql = "delete from psn where id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();

            String querySQL = "select * from psn";
            ResultSet resultSet = preparedStatement.executeQuery(querySQL);
            while (resultSet.next()) {
                System.out.println(resultSet.toString());
            }
            connection.commit();    // 手动提交事务
        } catch (Exception e) {
            connection.rollback(savepoint);
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
