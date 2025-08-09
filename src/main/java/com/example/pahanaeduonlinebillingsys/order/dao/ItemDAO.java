package com.example.pahanaeduonlinebillingsys.order.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDAO {

    public ItemAdd getItemByItemNo(String itemNo) {
        ItemAdd item = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM items WHERE itemno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, itemNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                item = new ItemAdd(
                        rs.getString("itemno"),
                        rs.getString("itemname"),
                        rs.getString("quantity"),
                        rs.getString("unitprice")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
