package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemViewDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ItemViewUnitTest {

    private ItemViewDAO itemViewDAOMock;
    private ItemViewService itemViewService;

    @BeforeEach
    void setUp() {
        itemViewDAOMock = Mockito.mock(ItemViewDAO.class);
        itemViewService = new ItemViewService() {
            private final ItemViewDAO dao = itemViewDAOMock;

            @Override
            public ItemAdd getItemByItemNo(String itemno) {
                return dao.getItemByItemNo(itemno);
            }
        };
    }

    @Test
    void testGetItemFound() {
        ItemAdd item = new ItemAdd("I002", "Pen", "20", "10");
        Mockito.when(itemViewDAOMock.getItemByItemNo("I002")).thenReturn(item);

        ItemAdd result = itemViewService.getItemByItemNo("I002");
        assertNotNull(result);
        assertEquals("Pen", result.getItemname());
        System.out.println("Item Found Unit Testing : " + result);
    }

    @Test
    void testGetItemNotFound() {
        Mockito.when(itemViewDAOMock.getItemByItemNo("I003")).thenReturn(null);

        ItemAdd result = itemViewService.getItemByItemNo("I003");
        assertNull(result);
        System.out.println("Item Not Found Unit Testing : " + result);
    }
}
