package org.example.JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306";
    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "AndreiTCM198";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl(DATABASE_URL);
            dataSource.setUser(DATABASE_USER);
            dataSource.setPassword(DATABASE_PASSWORD);

            connection = dataSource.getConnection();

        }
        return connection;
    }
}
