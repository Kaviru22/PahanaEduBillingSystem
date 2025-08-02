package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemViewDAO {

    public ItemAdd getItemByItemNo(String itemno) {
        ItemAdd itemAdd = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM items WHERE itemno=?");
            ps.setString(1, itemno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Item found!");
                itemAdd = new ItemAdd(
                        rs.getString("itemno"),
                        rs.getString("itemname"),
                        rs.getString("quanty"),
                        rs.getString("unitprice")
                );
            }
            else {
                System.out.println("Item not found in DB."); // 🔍 DEBUG
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemAdd;
    }

}
