package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemUpdateDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemUpdateUnitTest {
    private ItemUpdateDAO itemUpdateDAOMock;
    private ItemUpdateService itemUpdateService;

    @BeforeEach
    void setUp() {
        itemUpdateDAOMock = Mockito.mock(ItemUpdateDAO.class);
        itemUpdateService = new ItemUpdateService() {
            private final ItemUpdateDAO dao = itemUpdateDAOMock;

            @Override
            public ItemAdd getItemByItemNo(String itemno) {
                return dao.getItemByItemNo(itemno);
            }

            @Override
            public String updateItem(String originalItemno, ItemAdd itemAdd) {
                if (!originalItemno.equals(itemAdd.getItemno()) && dao.getItemByItemNo(itemAdd.getItemno()) != null) {
                    return "❌ Item already exists!";
                }
                if (dao.isItemNoExistsForOtherItem(itemAdd.getItemname(), originalItemno)) {
                    return "❌ Item Name already exists!";
                }
                boolean updated = dao.updateItem(originalItemno, itemAdd);
                return updated ? "Item updated successfully." : "Update failed.";
            }
        };
    }

    @Test
    void testUpdateSuccess() {
        ItemAdd existingItem = new ItemAdd("I010", "OldName", "10", "100");
        ItemAdd newItem = new ItemAdd("I010", "NewName", "20", "200");

        Mockito.when(itemUpdateDAOMock.getItemByItemNo("I010")).thenReturn(existingItem);
        Mockito.when(itemUpdateDAOMock.getItemByItemNo("I010")).thenReturn(null);  // New itemno check returns null
        Mockito.when(itemUpdateDAOMock.isItemNoExistsForOtherItem("NewName", "I010")).thenReturn(false);
        Mockito.when(itemUpdateDAOMock.updateItem("I010", newItem)).thenReturn(true);

        String result = itemUpdateService.updateItem("I010", newItem);
        assertEquals("Item updated successfully.", result);
        System.out.println("Item updated success Unit Testing : " + result);
    }

    @Test
    void testUpdateDuplicateItemNo() {
        ItemAdd newItem = new ItemAdd("I020", "NewName", "20", "200");

        Mockito.when(itemUpdateDAOMock.getItemByItemNo("I020")).thenReturn(newItem);

        String result = itemUpdateService.updateItem("I010", newItem);
        assertEquals("❌ Item already exists!", result);
        System.out.println("Item Already exists Unit Testing : " + result);
    }

    @Test
    void testUpdateDuplicateItemName() {
        ItemAdd newItem = new ItemAdd("I010", "DuplicateName", "20", "200");

        Mockito.when(itemUpdateDAOMock.getItemByItemNo("I010")).thenReturn(null);
        Mockito.when(itemUpdateDAOMock.isItemNoExistsForOtherItem("DuplicateName", "I010")).thenReturn(true);

        String result = itemUpdateService.updateItem("I010", newItem);
        assertEquals("❌ Item Name already exists!", result);
        System.out.println("Item Name Already Exists Unit Testing :" + result);
    }
}
