package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.user.model.User;

import java.sql.*;

public class UserDAO {

    public User getUserByUsername(String username) {
        User user = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(String originalUsername, User user) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE users SET username=?, firstname=?, lastname=?, email=?, password=? WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, originalUsername);

            int updated = ps.executeUpdate();
            success = updated > 0;

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
