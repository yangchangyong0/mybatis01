package com.ycy.jdbc;


import java.sql.*;

/**
 * Created by Administrator on 2015/8/27 0027.
 */
public class JdbcTest {

    public static void main(String[] args) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //隐射驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection=      DriverManager.getConnection("jdbc:mysql://localhost:3306/shiro?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root","123456");
            String sql="SELECT  * FROM user where username=?";
            preparedStatement=connection.prepareStatement(sql);
            System.out.println(preparedStatement);
            preparedStatement.setString(1,"王五");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("username")); ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
