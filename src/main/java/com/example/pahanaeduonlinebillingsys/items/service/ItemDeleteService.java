package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemDeleteDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemDelete;

public class ItemDeleteService {

    private final ItemDeleteDAO itemDeleteDAO = new ItemDeleteDAO();

    public String deleteItem(ItemDelete itemDelete) {

        try{
            boolean success = itemDeleteDAO.ItemDelete(itemDelete);
            if(success){
                return "✅ Item '" + itemDelete.getItemno() + "' deleted successfully.";

            }
            else {
                return "❌ Item not found.";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }
}
