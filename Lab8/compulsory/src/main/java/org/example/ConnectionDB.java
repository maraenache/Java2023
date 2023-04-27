package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singleton class
public class ConnectionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/Lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;

    private ConnectionDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
