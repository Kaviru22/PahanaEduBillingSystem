package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemAddUnitTest {

    private ItemDAO itemDAOMock;
    private ItemAddService itemAddService;

    @BeforeEach
    void setUp() {
        itemDAOMock = Mockito.mock(ItemDAO.class);
        itemAddService = new ItemAddService() {
            private final ItemDAO dao = itemDAOMock;

            @Override
            public String AddItems(ItemAdd itemAdd) {
                try {
                    if (dao.itemExists(itemAdd.getItemno())) {
                        return "❌ Item already exists!";
                    }
                    boolean inserted = dao.insertItems(itemAdd);
                    return inserted ? "✅ Item Added successfully!" : "❌ Failed to add item!";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testAddNewItemSuccess() throws Exception {
        ItemAdd item = new ItemAdd("I001", "Book", "10", "100");

        Mockito.when(itemDAOMock.itemExists("I001")).thenReturn(false);
        Mockito.when(itemDAOMock.insertItems(item)).thenReturn(true);

        String result = itemAddService.AddItems(item);
        assertEquals("✅ Item Added successfully!", result);
        System.out.println("Item Added Success Unit Testing : " + result);
    }

    @Test
    void testAddDuplicateItem() throws Exception {
        ItemAdd item = new ItemAdd("I001", "Book", "10", "100");

        Mockito.when(itemDAOMock.itemExists("I001")).thenReturn(true);

        String result = itemAddService.AddItems(item);
        assertEquals("❌ Item already exists!", result);
        System.out.println("Item Already Exists Unit Testing : " + result);
    }

    @Test
    void testInsertFails() throws Exception {
        ItemAdd item = new ItemAdd("I001", "Book", "10", "100");

        Mockito.when(itemDAOMock.itemExists("I001")).thenReturn(false);
        Mockito.when(itemDAOMock.insertItems(item)).thenReturn(false);

        String result = itemAddService.AddItems(item);
        assertEquals("❌ Failed to add item!", result);
        System.out.println("Item Insert Failed Unit Testing : " + result);
    }
}
