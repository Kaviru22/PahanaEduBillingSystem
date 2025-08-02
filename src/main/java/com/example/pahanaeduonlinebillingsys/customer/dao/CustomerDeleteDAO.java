package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDeleteDAO {

    public boolean customerDelete(CustomerDelete customerDelete) throws Exception {
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE accno=?")) {

            ps.setString(1, customerDelete.getAccNo());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

}
