package com.example.pahanaeduonlinebillingsys.customer.serivce;

import com.example.pahanaeduonlinebillingsys.customer.dao.CustomerDeleteDAO;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerDeleteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerDeleteUnitTest {

    private CustomerDeleteDAO customerDeleteDAOMock;
    private CustomerDeleteService customerDeleteService;

    @BeforeEach
    void setUp() {
        customerDeleteDAOMock = Mockito.mock(CustomerDeleteDAO.class);
        customerDeleteService = new CustomerDeleteService() {
            private final CustomerDeleteDAO dao = customerDeleteDAOMock;

            @Override
            public String deleteCustomer(CustomerDelete customerDelete) {
                try {
                    boolean success = dao.customerDelete(customerDelete);
                    if (success) {
                        return "✅ Customer '" + customerDelete.getAccNo() + "' deleted successfully.";
                    } else {
                        return "❌ Customer not found.";
                    }
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testDeleteCustomerSuccess() throws Exception {
        CustomerDelete custDel = new CustomerDelete("123123123");

        Mockito.when(customerDeleteDAOMock.customerDelete(custDel)).thenReturn(true);

        String result = customerDeleteService.deleteCustomer(custDel);
        assertEquals("✅ Customer '123123123' deleted successfully.", result);
        System.out.println("Customer Account Delete Successfully Unit Testing :" + result );
    }

    @Test
    void testDeleteCustomerNotFound() throws Exception {
        CustomerDelete custDel = new CustomerDelete("999999999");

        Mockito.when(customerDeleteDAOMock.customerDelete(custDel)).thenReturn(false);

        String result = customerDeleteService.deleteCustomer(custDel);
        assertEquals("❌ Customer not found.", result);
        System.out.println("Customer Account Not found Unit Testing :" + result );
    }

    @Test
    void testDeleteCustomerException() throws Exception {
        CustomerDelete custDel = new CustomerDelete("errorcase");

        Mockito.when(customerDeleteDAOMock.customerDelete(custDel)).thenThrow(new Exception("DB error"));

        String result = customerDeleteService.deleteCustomer(custDel);
        assertTrue(result.contains("Error: DB error"));
        System.out.println("Customer Account Delete Errors(DB error) Unit Testing :" + result );
    }
}
