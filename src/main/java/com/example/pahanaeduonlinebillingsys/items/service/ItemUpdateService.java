package com.example.pahanaeduonlinebillingsys.items.service;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.items.dao.ItemUpdateDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

public class ItemUpdateService {

    private ItemUpdateDAO itemUpdateDAO = new ItemUpdateDAO();

    public ItemAdd getItemByItemNo(String itemno) {
        return itemUpdateDAO.getItemByItemNo(itemno);
    }

    public String updateItem(String originalItemno, ItemAdd itemAdd) {
        String newItemNo = itemAdd.getItemno();
        String newItemName = itemAdd.getItemname();

        if (!originalItemno.equals(newItemNo) && itemUpdateDAO.getItemByItemNo(newItemNo) != null) {
            return "❌ Item already exists!";
        }

        // Check if mobile number already exists (but for a different account)
        if (itemUpdateDAO.isItemNoExistsForOtherItem(newItemName, originalItemno)) {
            return "❌ Item Name already exists!";
        }


        boolean updated = itemUpdateDAO.updateItem(originalItemno, itemAdd);
        return updated ? "Item updated successfully." : "Update failed.";
    }
}
