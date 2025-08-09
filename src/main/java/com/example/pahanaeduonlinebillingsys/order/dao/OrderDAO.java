package com.example.pahanaeduonlinebillingsys.order.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.order.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class OrderDAO {

    public boolean saveOrder(Order order, Map<String, ItemAdd> itemDetails) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // Insert into orders table
            String sqlOrder = "INSERT INTO orders (billid, accno) VALUES (?, ?)";
            PreparedStatement psOrder = conn.prepareStatement(sqlOrder);
            psOrder.setString(1, order.getBillid());
            psOrder.setString(2, order.getAccno());
            psOrder.executeUpdate();

            // Insert order items
            String sqlItems = "INSERT INTO order_items (billid, itemno, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement psItems = conn.prepareStatement(sqlItems);

            for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
                String itemno = entry.getKey();
                int qty = entry.getValue();
                ItemAdd item = itemDetails.get(itemno);

                psItems.setString(1, order.getBillid());
                psItems.setString(2, itemno);
                psItems.setInt(3, qty);

                java.math.BigDecimal unitPrice = new java.math.BigDecimal(item.getUnitprice());
                java.math.BigDecimal totalPrice = unitPrice.multiply(new java.math.BigDecimal(qty));
                psItems.setBigDecimal(4, totalPrice);

                psItems.addBatch();
            }

            psItems.executeBatch();

            conn.commit();
            success = true;

            psOrder.close();
            psItems.close();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

}
