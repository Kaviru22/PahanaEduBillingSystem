package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerViewIntegrateTest {

    @Test
    void testGetCustomerByAccnoRealDB() {
        CustomerService service = new CustomerService();

        // Use an accno that exists in your real DB for meaningful test
        String existingAccNo = "123123123";

        CustomerRegister customer = service.getCustomerByAccno(existingAccNo);

        assertNotNull(customer, "Customer should exist in DB");
        assertEquals(existingAccNo, customer.getAccNo());
        System.out.println("Integration test found customer: " + customer.getFirstName());
    }

    @Test
    void testGetCustomerByAccnoNotExist() {
        CustomerService service = new CustomerService();

        // Use an accno that does NOT exist
        String nonExistentAccNo = "999999999";

        CustomerRegister customer = service.getCustomerByAccno(nonExistentAccNo);

        assertNull(customer, "Customer should not exist");
        System.out.println("Integration test customer not found: " + customer);
    }
}
