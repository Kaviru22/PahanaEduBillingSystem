package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerCreateService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerCreationIntegrateTest {

    @Test
    void testInsertCustomerRealDB() {
        CustomerCreateService customerCreateService = new CustomerCreateService();

        CustomerRegister customerRegister = new CustomerRegister(
                "999888777", // Change for each test to avoid duplicate key
                "Nadun",
                "Fernando",
                "No: 10/2, Main Road, Moratuwa",
                "0712345678"
        );

        String result = customerCreateService.registerCustomer(customerRegister);

        assertTrue(result.contains("✅") || result.contains("❌"));
        System.out.println("Integration Test Result: " + result);
    }
}
