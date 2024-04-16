package com.example.application.views.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/ooad";
    private static final String USER = "root";
    private static final String PASSWORD = "ananya123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
