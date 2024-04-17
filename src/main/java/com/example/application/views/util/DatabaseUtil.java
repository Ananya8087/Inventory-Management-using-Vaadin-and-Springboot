package com.example.application.views.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseUtil() {}

    // Public method to get the instance of Connection
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseUtil.class) {
                if (connection == null) {  // Double-check locking
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (Exception e) {
                        throw new RuntimeException("Error connecting to the database", e);
                    }
                }
            }
        }
        return connection;
    }
}
