package org.example.JDBC;

import java.sql.*;

public class JdbcConnectionExample {
    public static void main(String[] args) {

        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex2",
                    "root",
                    "AndreiTCM198");
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                System.out.println (resultSet);
            }


            System.out.println("Connection to data base successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
