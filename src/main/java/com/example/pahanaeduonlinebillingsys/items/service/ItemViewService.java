package com.example.pahanaeduonlinebillingsys.items.service;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerViewDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.items.dao.ItemViewDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

public class ItemViewService {

    private ItemViewDAO itemViewDAO = new ItemViewDAO();

    public ItemAdd getItemByItemNo(String itemno) {
        return itemViewDAO.getItemByItemNo(itemno);
    }

}
