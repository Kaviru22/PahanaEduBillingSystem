package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.items.model.ItemDelete;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemDeleteDAO {

    public boolean ItemDelete(ItemDelete itemDelete) throws Exception {
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno=?")) {

            ps.setString(1, itemDelete.getItemno());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
