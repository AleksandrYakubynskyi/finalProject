package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public static final String URL = "jdbc:mysql://localhost:3306/*****";
    public static final String USER = "***";
    public static final String PASSWORD = "****";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
