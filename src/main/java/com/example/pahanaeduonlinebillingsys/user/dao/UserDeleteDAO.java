package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDeleteDAO {

    public boolean userDelete(UserDelete userDelete) throws Exception{
        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?")) {

            ps.setString(1, userDelete.getUsername());
            int rows = ps.executeUpdate();
            return rows > 0;
        }


    }
}
