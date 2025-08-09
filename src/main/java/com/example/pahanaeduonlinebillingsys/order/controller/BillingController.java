package com.example.pahanaeduonlinebillingsys.order.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerService;
import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.order.model.Order;
import com.example.pahanaeduonlinebillingsys.order.service.ItemService;
import com.example.pahanaeduonlinebillingsys.order.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/billing")
public class BillingController extends HttpServlet {

    private CustomerService customerService = new CustomerService();
    private ItemService itemService = new ItemService();
    private OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accNo = req.getParameter("accno");
        if (accNo != null && !accNo.trim().isEmpty()) {
            CustomerRegister cust = customerService.getCustomerByAccno(accNo.trim());
            if (cust != null) {
                req.setAttribute("customer", cust);
            } else {
                req.setAttribute("message", "Customer not found.");
            }
        }
        req.getRequestDispatcher("billing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accNo = req.getParameter("accno");
        String action = req.getParameter("action");  // will be "pay" if pay button pressed

        String[] itemNos = req.getParameterValues("itemno");
        String[] qtys = req.getParameterValues("quantity");

        if (accNo == null || accNo.trim().isEmpty()) {
            req.setAttribute("message", "Account No is required.");
            req.getRequestDispatcher("billing.jsp").forward(req, resp);
            return;
        }

        if (itemNos == null || qtys == null || itemNos.length != qtys.length) {
            req.setAttribute("message", "Invalid item details.");
            req.getRequestDispatcher("billing.jsp").forward(req, resp);
            return;
        }

        Map<String, Integer> itemMap = new LinkedHashMap<>();
        Set<String> uniqueItems = new HashSet<>();

        for (int i = 0; i < itemNos.length; i++) {
            String itemNo = itemNos[i].trim();
            if (itemNo.isEmpty()) continue;

            int qty;
            try {
                qty = Integer.parseInt(qtys[i]);
            } catch (NumberFormatException e) {
                qty = 0;
            }
            if (qty <= 0) continue;

            if (!uniqueItems.contains(itemNo)) {
                itemMap.put(itemNo, qty);
                uniqueItems.add(itemNo);
            } else {
                itemMap.put(itemNo, itemMap.get(itemNo) + qty);
            }
        }

        CustomerRegister cust = customerService.getCustomerByAccno(accNo);
        if (cust == null) {
            req.setAttribute("message", "Customer not found.");
            req.getRequestDispatcher("billing.jsp").forward(req, resp);
            return;
        }

        Map<String, ItemAdd> itemDetails = itemService.getItemsByNumbers(itemMap.keySet());
        if (itemDetails.size() != itemMap.size()) {
            req.setAttribute("message", "Some items not found.");
            req.setAttribute("customer", cust);
            req.getRequestDispatcher("billing.jsp").forward(req, resp);
            return;
        }

        // If the action is pay, save the order
        if ("pay".equals(action)) {
            Order order = new Order();
            order.setAccno(accNo);
            order.setBillid(generateBillId());
            order.setItems(itemMap);

            boolean saved = orderService.saveOrder(order, itemDetails);

            if (saved) {
                req.setAttribute("message", "Payment successful! Bill ID: " + order.getBillid());
                req.setAttribute("billId", order.getBillid());
                // Optionally clear items after payment or keep as is
                // Here we keep them to show in receipt
            } else {
                req.setAttribute("message", "Failed to save the bill.");
            }
        } else {
            req.setAttribute("message", "Bill calculated. Click Pay Bill to finalize.");
        }

        req.setAttribute("customer", cust);
        req.setAttribute("itemMap", itemMap);
        req.setAttribute("itemDetails", itemDetails);

        req.getRequestDispatcher("billing.jsp").forward(req, resp);
    }

    private String generateBillId() {
        int randomNum = (int) (Math.random() * 10000);
        String letters = UUID.randomUUID().toString().replaceAll("[^A-Za-z]", "").toUpperCase();
        letters = letters.length() >= 6 ? letters.substring(0, 6) : letters;
        return String.format("%04d%s", randomNum, letters);
    }
}
