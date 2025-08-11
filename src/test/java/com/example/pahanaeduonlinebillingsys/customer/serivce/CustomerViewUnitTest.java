package com.example.pahanaeduonlinebillingsys.customer.serivce;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerViewDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

public class CustomerViewUnitTest {

    private CustomerViewDAO customerViewDAOMock;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerViewDAOMock = Mockito.mock(CustomerViewDAO.class);
        customerService = new CustomerService() {
            private final CustomerViewDAO dao = customerViewDAOMock;

            @Override
            public CustomerRegister getCustomerByAccno(String accno) {
                return dao.getCustomerByAccno(accno);
            }
        };
    }

    @Test
    void testGetCustomerFound() {
        CustomerRegister mockCustomer = new CustomerRegister("123", "John", "Doe", "Some Address", "0771234567");
        Mockito.when(customerViewDAOMock.getCustomerByAccno("123")).thenReturn(mockCustomer);

        CustomerRegister result = customerService.getCustomerByAccno("123");

        assertNotNull(result);
        assertEquals("123", result.getAccNo());
        assertEquals("John", result.getFirstName());
        System.out.println("Customer Already Found Unit Testing :" + result.getAccNo() + " " + result.getFirstName() );

    }

    @Test
    void testGetCustomerNotFound() {
        Mockito.when(customerViewDAOMock.getCustomerByAccno(anyString())).thenReturn(null);

        CustomerRegister result = customerService.getCustomerByAccno("999");

        assertNull(result);
        System.out.println("Customer Not Found Unit Testing :" + result );
    }
}
