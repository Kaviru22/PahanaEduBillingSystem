package com.example.pahanaeduonlinebillingsys.items.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.items.model.ItemDelete;
import com.example.pahanaeduonlinebillingsys.items.service.ItemAddService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDeleteIntegrateTest {

    private ItemDeleteDAO itemDeleteDAO;

    @BeforeEach
    void setUp() throws Exception {
        itemDeleteDAO = new ItemDeleteDAO();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "DELTEST");
            ps.executeUpdate();
            ps.close();

            ps = conn.prepareStatement("INSERT INTO items (itemno, itemname, quanty, unitprice) VALUES (?, ?, ?, ?)");
            ps.setString(1, "DELTEST");
            ps.setString(2, "DeleteTestItem");
            ps.setString(3, "10");
            ps.setString(4, "100");
            ps.executeUpdate();
            ps.close();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE itemno = ?");
            ps.setString(1, "DELTEST");
            ps.executeUpdate();
            ps.close();
        }
    }

    @Test
    void testDeleteItemSuccess() throws Exception {
        ItemDelete itemDelete = new ItemDelete("DELTEST");
        boolean deleted = itemDeleteDAO.ItemDelete(itemDelete);
        assertTrue(deleted);
        System.out.println("Item Delete Success Integrating Testing : " + itemDelete);
    }

    @Test
    void testDeleteItemNotFound() throws Exception {
        ItemDelete itemDelete = new ItemDelete("NONEXISTENT");
        boolean deleted = itemDeleteDAO.ItemDelete(itemDelete);
        assertFalse(deleted);
        System.out.println("Item Delete Failure Integrating Testing : " + itemDelete);
    }
}
