package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public static final String URL = "jdbc:mysql://localhost:3306/Aleksandr";
    public static final String USER = "root";
    public static final String PASSWORD = "rootroot";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
