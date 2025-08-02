package com.example.pahanaeduonlinebillingsys.customer.service;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerViewDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.user.model.User;

public class CustomerService {

    private CustomerViewDAO customerViewDAO = new CustomerViewDAO();

    public CustomerRegister getCustomerByAccno(String accno) {
        return customerViewDAO.getCustomerByAccno(accno);
    }

}
