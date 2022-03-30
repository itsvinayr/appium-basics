package com.appium.database;

import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/qaDatabase", "root", "test");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employeeInfo where name='Sam'");
        while(resultSet.next()) {
            System.out.println(resultSet.getString("location"));
        }
    }
}
