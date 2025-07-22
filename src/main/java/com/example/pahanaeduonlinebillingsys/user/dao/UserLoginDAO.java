package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserAbstract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO extends UserAbstract {

    @Override
    public boolean validateUser(UserLogin userLogin) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userLogin.getUsername());
            ps.setString(2, userLogin.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                adduser(userLogin); // Store in memory
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
