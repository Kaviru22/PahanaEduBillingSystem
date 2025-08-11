package com.example.pahanaeduonlinebillingsys.customer.serivce;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerUpdateDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerUpdateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUpdateUnitTest {

    private CustomerUpdateDAO customerUpdateDAOMock;
    private CustomerUpdateService customerUpdateService;

    @BeforeEach
    void setUp() {
        customerUpdateDAOMock = Mockito.mock(CustomerUpdateDAO.class);
        customerUpdateService = new CustomerUpdateService() {
            private final CustomerUpdateDAO dao = customerUpdateDAOMock;

            @Override
            public CustomerRegister getCustomerByAccNo(String accno) {
                return dao.getCustomerByAccNo(accno);
            }

            @Override
            public String updateCustomer(String originalAccno, CustomerRegister customerRegister) {
                String newAccNo = customerRegister.getAccNo();
                String newMobileNo = customerRegister.getMobileNo();

                if (!originalAccno.equals(newAccNo) && dao.getCustomerByAccNo(newAccNo) != null) {
                    return "❌ Account number already exists!";
                }
                if (dao.isMobileNoExistsForOtherAccount(newMobileNo, originalAccno)) {
                    return "❌ Mobile number already exists!";
                }
                boolean updated = dao.updateCustomer(originalAccno, customerRegister);
                return updated ? "Customer updated successfully." : "Update failed.";
            }
        };
    }

    @Test
    void testUpdateCustomerSuccess() {
        CustomerRegister existingCustomer = new CustomerRegister("123", "John", "Doe", "Addr", "0771234567");
        CustomerRegister updatedCustomer = new CustomerRegister("123", "John", "Smith", "Addr2", "0771234567");

        Mockito.when(customerUpdateDAOMock.getCustomerByAccNo("123")).thenReturn(existingCustomer);
        Mockito.when(customerUpdateDAOMock.isMobileNoExistsForOtherAccount("0771234567", "123")).thenReturn(false);
        Mockito.when(customerUpdateDAOMock.updateCustomer("123", updatedCustomer)).thenReturn(true);

        String result = customerUpdateService.updateCustomer("123", updatedCustomer);
        assertEquals("Customer updated successfully.", result);
        System.out.println("Customer Account Updated Successfully Unit Testing :" + result );
    }

    @Test
    void testUpdateCustomerAccountNoExists() {
        CustomerRegister newAccCustomer = new CustomerRegister("999", "Jane", "Doe", "Addr", "0777654321");

        Mockito.when(customerUpdateDAOMock.getCustomerByAccNo("999")).thenReturn(newAccCustomer);

        // Trying to change original "123" accno to "999" which already exists
        String result = customerUpdateService.updateCustomer("123", newAccCustomer);
        assertEquals("❌ Account number already exists!", result);
        System.out.println("Customer Account Number Already exists Unit Testing :" + result );
    }

    @Test
    void testUpdateCustomerMobileExists() {
        CustomerRegister cust = new CustomerRegister("123", "John", "Doe", "Addr", "0771234567");

        Mockito.when(customerUpdateDAOMock.getCustomerByAccNo("123")).thenReturn(null); // acc no is not duplicate
        Mockito.when(customerUpdateDAOMock.isMobileNoExistsForOtherAccount("0771234567", "123")).thenReturn(true);

        String result = customerUpdateService.updateCustomer("123", cust);
        assertEquals("❌ Mobile number already exists!", result);
        System.out.println("Mobile Number already exists Unit Testing :" + result );
    }

    @Test
    void testUpdateCustomerFailed() {
        CustomerRegister cust = new CustomerRegister("123", "John", "Doe", "Addr", "0771234567");

        Mockito.when(customerUpdateDAOMock.getCustomerByAccNo("123")).thenReturn(null);
        Mockito.when(customerUpdateDAOMock.isMobileNoExistsForOtherAccount("0771234567", "123")).thenReturn(false);
        Mockito.when(customerUpdateDAOMock.updateCustomer("123", cust)).thenReturn(false);

        String result = customerUpdateService.updateCustomer("123", cust);
        assertEquals("Update failed.", result);
        System.out.println("Customer Account Updated failed Unit Testing :" + result );
    }
}
