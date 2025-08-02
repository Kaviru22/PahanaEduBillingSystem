package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemUpdateDAO {

    public ItemAdd getItemByItemNo(String itemno) {
        ItemAdd itemAdd = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM items WHERE itemno=?");
            ps.setString(1, itemno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                itemAdd = new ItemAdd(
                        rs.getString("itemno"),
                        rs.getString("itemname"),
                        rs.getString("quanty"),
                        rs.getString("unitprice")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemAdd;
    }

    public boolean isItemNoExistsForOtherItem(String itemname, String itemno) {
        boolean exists = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT itemno FROM items WHERE itemname = ? AND itemno <> ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, itemname);
            ps.setString(2, itemno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    public boolean updateItem(String originalItemno, ItemAdd itemAdd) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE items SET itemno=?, itemname=?, quanty=?, unitprice=? WHERE itemno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, itemAdd.getItemno());
            ps.setString(2, itemAdd.getItemname());
            ps.setString(3, itemAdd.getQuantity());
            ps.setString(4, itemAdd.getUnitprice());
            ps.setString(5, originalItemno);

            int updated = ps.executeUpdate();
            success = updated > 0;

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
