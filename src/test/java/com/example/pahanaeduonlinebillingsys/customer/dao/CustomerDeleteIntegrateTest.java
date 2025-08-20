package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerDeleteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDeleteIntegrateTest {

    private final CustomerDeleteService customerDeleteService = new CustomerDeleteService();

    @Test
    void testDeleteCustomerSuccessRealDB() {
        // Use an accno that exists in your DB for safe deletion test
        CustomerDelete custDel = new CustomerDelete("999999999");

        String result = customerDeleteService.deleteCustomer(custDel);
        assertEquals("✅ Customer '999999999' deleted successfully.", result);
        System.out.println("Integration test Customer Delete Test :" + result );
    }

    @Test
    void testDeleteCustomerNotFoundRealDB() {
        // Use a made-up or definitely non-existing accno
        CustomerDelete custDel = new CustomerDelete("nonexistentaccno");

        String result = customerDeleteService.deleteCustomer(custDel);
        assertEquals("❌ Customer not found.", result);
        System.out.println("Integration test Customer Not Found to Delete Test :" + result );
    }
}
