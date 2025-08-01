package com.example.pahanaeduonlinebillingsys.customer.service;

import com.example.pahanaeduonlinebillingsys.customer.controller.NewCustomer;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerDAO;

public class CustomerCreateService {

    private final CustomerDAO customerDAO = new CustomerDAO();

    public String registerCustomer(CustomerRegister customerRegister) {
        try {

            int accNo = customerRegister.getAccNo();
            if (customerDAO.customerExists(accNo)) {
                return "❌ Customer already exists!";
            }

            boolean inserted = customerDAO.insertCustomer(customerRegister);
            return inserted ? "✅ Customer created successfully!" : "❌ Customer to create user!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}

