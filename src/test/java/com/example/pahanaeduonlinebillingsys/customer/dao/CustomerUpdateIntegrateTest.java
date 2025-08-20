package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerUpdateService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUpdateIntegrateTest {

    private final CustomerUpdateService customerUpdateService = new CustomerUpdateService();

    @Test
    void testUpdateCustomerSuccessRealDB() {
        String originalAccNo = "12345"; // use existing valid accno in your DB
        CustomerRegister updatedCustomer = new CustomerRegister(originalAccNo, "UpdatedFast", "UpdatedLast", "Updated Address", "0700000000");

        String result = customerUpdateService.updateCustomer(originalAccNo, updatedCustomer);
        assertEquals("Customer updated successfully.", result);
        System.out.println("Integration test found customer: " + result);
    }

    @Test
    void testUpdateCustomerAccountNoExistsRealDB() {
        // Assuming 123123123 exists, and 999999999 also exists in DB as different account
        String originalAccNo = "123123123";
        CustomerRegister custWithExistingAccNo = new CustomerRegister("999999999", "Name", "Name", "Address", "0700000001");

        String result = customerUpdateService.updateCustomer(originalAccNo, custWithExistingAccNo);
        assertEquals("❌ Account number already exists!", result);
        System.out.println("Integration test Account found customer: " + result);
    }

    @Test
    void testUpdateCustomerMobileExistsRealDB() {
        // Use mobile number that exists for a different account than originalAccNo
        String originalAccNo = "123123123";
        CustomerRegister custWithExistingMobile = new CustomerRegister(originalAccNo, "Name", "Name", "Address", "0712345678");

        String result = customerUpdateService.updateCustomer(originalAccNo, custWithExistingMobile);
        assertEquals("❌ Mobile number already exists!", result);
        System.out.println("Integration test Mobile found customer: " + custWithExistingMobile.getMobileNo());
    }

    @Test
    void testUpdateCustomerFailedRealDB() {
        // Update with a non-existing original account number to simulate failure
        String originalAccNo = "nonexistentaccno";
        CustomerRegister cust = new CustomerRegister(originalAccNo, "Name", "Name", "Address", "0700000000");

        String result = customerUpdateService.updateCustomer(originalAccNo, cust);
        assertEquals("Update failed.", result);
        System.out.println("Integration test Customer Update Failed: " + cust.getAccNo());
    }
}
