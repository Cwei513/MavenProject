package com.atguigu;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/***
 * @author : chen wei
 * @date   : 2024/5/8 5:49
 * @Version: 1.0
 * @Description   : 
 *
 */
public class MavenTest {
    @Test
    public void test01(){
        System.out.println("hello world");
    }

    @Test
    public void test02() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/d01", "root", "123456");
        // DriverManager.getConnection("jdbc:mysql:///day01",info);
        // DriverManager.getConnection("jdbc:mysql:///day01?user=root&password=123456");


        // 创建statement对象，并传递SQL语句
//        Statement statement = connection.createStatement();
        String sql = "select * from users where account = ? and password = ? ; ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给占位符赋值
        /**
         * 参数1： int 占位符的下角标 从左到右，从1开始
         * 参数2： object 占位符的值
         */
        preparedStatement.setObject(1,1000);
        preparedStatement.setObject(2,"root");

        //发送SQL语句，并且获取返回结果
        //statement.executeQuery(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //结果集解析
        if (resultSet.next()){}
        else {}
        //7.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
