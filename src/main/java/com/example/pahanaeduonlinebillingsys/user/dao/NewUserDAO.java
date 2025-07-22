package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewUserDAO {

    public boolean userExists(String username, String email) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, email);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close(); ps.close(); conn.close();
        return exists;
    }

    public boolean insertUser(UserRegister userRegister) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO users (username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userRegister.getUsername());
        ps.setString(2, userRegister.getFirstName());
        ps.setString(3, userRegister.getLastName());
        ps.setString(4, userRegister.getEmail());
        ps.setString(5, userRegister.getPassword());

        int result = ps.executeUpdate();
        ps.close(); conn.close();
        return result > 0;
    }
}
