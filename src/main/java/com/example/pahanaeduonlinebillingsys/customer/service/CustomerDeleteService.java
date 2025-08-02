package com.example.pahanaeduonlinebillingsys.customer.service;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerDeleteDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;

public class CustomerDeleteService {

    private final CustomerDeleteDAO customerDeleteDAO = new CustomerDeleteDAO();

    public String deleteCustomer(CustomerDelete customerDelete) {

        try{
            boolean success = customerDeleteDAO.customerDelete(customerDelete);
            if(success){
                return "✅ Customer '" + customerDelete.getAccNo() + "' deleted successfully.";

            }
            else {
                return "❌ Customer not found.";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }
}
