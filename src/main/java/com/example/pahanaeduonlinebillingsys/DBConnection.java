package com.example.pahanaeduonlinebillingsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/pahanaEduOnlineShop";
        String username = "postgres";
        String password = "kaviru123";
        return DriverManager.getConnection(url, username, password);
    }
}

