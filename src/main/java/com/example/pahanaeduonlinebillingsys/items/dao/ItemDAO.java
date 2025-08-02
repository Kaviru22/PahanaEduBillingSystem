package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDAO {

    public boolean itemExists(String itemno) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM items WHERE itemno = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, itemno);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close(); ps.close(); conn.close();
        return exists;
    }

    public boolean insertItems(ItemAdd itemAdd) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO items (itemno, itemname, quanty, unitprice) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, itemAdd.getItemno());
        ps.setString(2, itemAdd.getItemname());
        ps.setString(3, itemAdd.getQuantity());
        ps.setString(4, itemAdd.getUnitprice());

        int result = ps.executeUpdate();
        ps.close(); conn.close();
        return result > 0;
    }
}
