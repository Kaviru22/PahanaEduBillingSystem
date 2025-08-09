package com.example.pahanaeduonlinebillingsys.order.service;

import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.order.dao.OrderDAO;
import com.example.pahanaeduonlinebillingsys.order.model.Order;

import java.util.Map;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();

    public boolean saveOrder(Order order, Map<String, ItemAdd> itemDetails) {
        return orderDAO.saveOrder(order, itemDetails);
    }
}
