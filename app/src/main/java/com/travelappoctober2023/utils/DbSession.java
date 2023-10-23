package com.travelappoctober2023.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSession {
    protected static Connection connect() {
        final String url = "jdbc:postgresql://localhost:5432/roadcorner";
        final String admin_rc = "admin_rc";
        final String password = "coucou";
        try {
            Connection conn = DriverManager.getConnection(url, admin_rc, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
