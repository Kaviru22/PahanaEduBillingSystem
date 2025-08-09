package com.example.pahanaeduonlinebillingsys.order.service;

import com.example.pahanaeduonlinebillingsys.items.dao.ItemDAO;
import com.example.pahanaeduonlinebillingsys.items.dao.ItemViewDAO;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemService {

    private ItemViewDAO itemViewDAO = new ItemViewDAO();

    // Return map of itemno to ItemAdd object for multiple items
    public Map<String, ItemAdd> getItemsByNumbers(Collection<String> itemNos) {
        Map<String, ItemAdd> map = new HashMap<>();
        for (String itemNo : itemNos) {
            ItemAdd item = itemViewDAO.getItemByItemNo(itemNo);
            if (item != null) {
                map.put(itemNo, item);
            }
        }
        return map;
    }
}
