package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;

public class ItemUpdateIntegrateTest {

    private ItemUpdateDAO itemUpdateDAO;

    @BeforeEach
    void setUp() throws Exception {
        itemUpdateDAO = new ItemUpdateDAO();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno IN (?, ?)");
            ps.setString(1, "UPD01");
            ps.setString(2, "UPD02");
            ps.executeUpdate();
            ps.close();

            ps = conn.prepareStatement("INSERT INTO items (itemno, itemname, quanty, unitprice) VALUES (?, ?, ?, ?)");
            ps.setString(1, "UPD01");
            ps.setString(2, "ItemOld");
            ps.setString(3, "10");
            ps.setString(4, "100");
            ps.executeUpdate();
            ps.close();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno IN (?, ?)");
            ps.setString(1, "UPD01");
            ps.setString(2, "UPD02");
            ps.executeUpdate();
            ps.close();
        }
    }

    @Test
    void testUpdateItemSuccess() {
        ItemAdd newItem = new ItemAdd("UPD02", "ItemNew", "20", "200");
        boolean updated = itemUpdateDAO.updateItem("UPD01", newItem);
        assertTrue(updated);

        ItemAdd fetched = itemUpdateDAO.getItemByItemNo("UPD02");
        assertNotNull(fetched);
        assertEquals("ItemNew", fetched.getItemname());
        System.out.println("Item Update Success Integrating Testing : " + fetched);
    }

    @Test
    void testGetItemByItemNo() {
        ItemAdd item = itemUpdateDAO.getItemByItemNo("UPD01");
        assertNotNull(item);
        assertEquals("ItemOld", item.getItemname());
        System.out.println("Item retrieve by Item Name Integrating Testing : " + item);
    }

    @Test
    void testIsItemNoExistsForOtherItem() {
        assertFalse(itemUpdateDAO.isItemNoExistsForOtherItem("SomeName", "NONEXISTENT"));
        assertTrue(itemUpdateDAO.isItemNoExistsForOtherItem("ItemOld", "UPD02"));
        System.out.println(itemUpdateDAO.isItemNoExistsForOtherItem("ItemNew", "UPD01"));
    }
}
