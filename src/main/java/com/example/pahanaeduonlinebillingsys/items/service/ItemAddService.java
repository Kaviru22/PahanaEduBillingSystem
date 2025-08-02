package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

public class ItemAddService {

    private final ItemDAO itemDAO = new ItemDAO();

    public String AddItems(ItemAdd itemAdd) {

        try {

            String accNo = itemAdd.getItemno();
            if (itemDAO.itemExists(accNo)) {
                return "❌ Item already exists!";
            }

            boolean inserted = itemDAO.insertItems(itemAdd);
            return inserted ? "✅ Item Added successfully!" : "❌ Failed to add item!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
