package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemDeleteDAO;
import com.example.pahanaeduonlinebillingsys.items.dao.ItemUpdateDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.items.model.ItemDelete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemDeleteUnitTest {

    private ItemDeleteDAO itemDeleteDAOMock;
    private ItemDeleteService itemDeleteService;

    @BeforeEach
    void setUp() {
        itemDeleteDAOMock = Mockito.mock(ItemDeleteDAO.class);
        itemDeleteService = new ItemDeleteService() {
            private final ItemDeleteDAO dao = itemDeleteDAOMock;

            @Override
            public String deleteItem(ItemDelete itemDelete) {
                try {
                    boolean success = dao.ItemDelete(itemDelete);
                    if (success) {
                        return "✅ Item '" + itemDelete.getItemno() + "' deleted successfully.";
                    }
                    return "❌ Item not found.";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testDeleteSuccess() throws Exception {
        ItemDelete itemDelete = new ItemDelete("DEL01");

        Mockito.when(itemDeleteDAOMock.ItemDelete(itemDelete)).thenReturn(true);

        String result = itemDeleteService.deleteItem(itemDelete);
        assertEquals("✅ Item 'DEL01' deleted successfully.", result);
        System.out.println("Item Delete Success Unit Testing : " + result);
    }

    @Test
    void testDeleteNotFound() throws Exception {
        ItemDelete itemDelete = new ItemDelete("DEL02");

        Mockito.when(itemDeleteDAOMock.ItemDelete(itemDelete)).thenReturn(false);

        String result = itemDeleteService.deleteItem(itemDelete);
        assertEquals("❌ Item not found.", result);
        System.out.println("Item Delete Not Found Unit Testing : " + result);
    }
}
