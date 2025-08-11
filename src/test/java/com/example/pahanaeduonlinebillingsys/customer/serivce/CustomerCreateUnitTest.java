package com.example.pahanaeduonlinebillingsys.customer.serivce;


import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerCreateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class CustomerCreateUnitTest {

    private CustomerDAO customerDAOMock;
    private CustomerCreateService customerCreateService;

    @BeforeEach
    void setUp() {
        customerDAOMock = Mockito.mock(CustomerDAO.class);
        customerCreateService = new CustomerCreateService() {
            // Override DAO with mock
            private final CustomerDAO dao = customerDAOMock;

            @Override
            public String registerCustomer(CustomerRegister customerRegister) {
                try {
                    String accNo = customerRegister.getAccNo();
                    if (dao.customerExists(accNo)) {
                        return "❌ Customer already exists!";
                    }
                    boolean inserted = dao.insertCustomer(customerRegister);
                    return inserted ? "✅ Customer created successfully!" : "❌ Customer to create user!";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testCustomerAlreadyExists() throws Exception {
        Mockito.when(customerDAOMock.customerExists("123")).thenReturn(true);

        String result = customerCreateService.registerCustomer(
                new CustomerRegister("123", "John", "Doe", "Address", "0771234567")
        );

        assertEquals("❌ Customer already exists!", result);
        System.out.println("Customer Already exists Unit Testing :" + result );
    }

    @Test
    void testCustomerInsertedSuccessfully() throws Exception {
        Mockito.when(customerDAOMock.customerExists("123")).thenReturn(false);
        Mockito.when(customerDAOMock.insertCustomer(any())).thenReturn(true);

        String result = customerCreateService.registerCustomer(
                new CustomerRegister("123", "John", "Doe", "Address", "0771234567")
        );

        assertEquals("✅ Customer created successfully!", result);
        System.out.println("Customer Created Successfully Unit Testing:" + result );
    }

    @Test
    void testCustomerInsertFailed() throws Exception {
        Mockito.when(customerDAOMock.customerExists("123")).thenReturn(false);
        Mockito.when(customerDAOMock.insertCustomer(any())).thenReturn(false);

        String result = customerCreateService.registerCustomer(
                new CustomerRegister("123", "John", "Doe", "Address", "0771234567")
        );

        assertEquals("❌ Customer to create user!", result);
        System.out.println("Customer Creates Failed Unit Testing :" + result );
    }

}
