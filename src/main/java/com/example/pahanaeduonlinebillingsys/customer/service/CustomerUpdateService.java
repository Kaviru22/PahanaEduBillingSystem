package com.example.pahanaeduonlinebillingsys.customer.service;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerUpdateDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.user.model.User;

public class CustomerUpdateService {

    private CustomerUpdateDAO customerDAO = new CustomerUpdateDAO();

    public CustomerRegister getCustomerByAccNo(String accno) {
        return customerDAO.getCustomerByAccNo(accno);
    }

    public String updateCustomer(String originalAccno, CustomerRegister customerRegister) {
        String newAccNo = customerRegister.getAccNo();
        String newMobileNo = customerRegister.getMobileNo();

        if (!originalAccno.equals(newAccNo) && customerDAO.getCustomerByAccNo(newAccNo) != null) {
            return "❌ Account number already exists!";
        }

        // Check if mobile number already exists (but for a different account)
        if (customerDAO.isMobileNoExistsForOtherAccount(newMobileNo, originalAccno)) {
            return "❌ Mobile number already exists!";
        }


        boolean updated = customerDAO.updateCustomer(originalAccno, customerRegister);
        return updated ? "Customer updated successfully." : "Update failed.";
    }
}
