package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemViewIntegrateTest {

    private ItemViewDAO itemViewDAO;

    @BeforeEach
    void setUp() throws Exception {
        itemViewDAO = new ItemViewDAO();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "TESTVIEW");
            ps.executeUpdate();

            ps = conn.prepareStatement("INSERT INTO items (itemno, itemname, quanty, unitprice) VALUES (?, ?, ?, ?)");
            ps.setString(1, "TESTVIEW");
            ps.setString(2, "ViewItem");
            ps.setString(3, "15");
            ps.setString(4, "30");
            ps.executeUpdate();
            ps.close();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "TESTVIEW");
            ps.executeUpdate();
            ps.close();
        }
    }

    @Test
    void testGetItemByItemNo() {
        ItemAdd item = itemViewDAO.getItemByItemNo("TESTVIEW");
        assertNotNull(item);
        assertEquals("ViewItem", item.getItemname());
        System.out.println("Item Retrieve by Item No Integrating Testing : " + item);
    }
}
