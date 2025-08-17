
package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemAddIntegrateTest {

    private ItemDAO itemDAO;

    @BeforeEach
    void setUp() throws Exception {
        itemDAO = new ItemDAO();
        // Clean up before
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "TEST01");
            ps.executeUpdate();
            ps.close();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        // Clean up after
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "TEST01");
            ps.executeUpdate();
            ps.close();
        }
    }

    @Test
    void testInsertAndExists() throws Exception {
        ItemAdd item = new ItemAdd("TEST01", "TestItem", "5", "50");

        assertFalse(itemDAO.itemExists("TEST01"));
        assertTrue(itemDAO.insertItems(item));
        assertTrue(itemDAO.itemExists("TEST01"));
        System.out.println("Item Insert and Exists Integrating Testing : " + item);
    }
}
