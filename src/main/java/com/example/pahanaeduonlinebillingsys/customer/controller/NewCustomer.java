package com.example.pahanaeduonlinebillingsys.customer.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerCreateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newcustomer")
public class NewCustomer extends HttpServlet {
    private final CustomerCreateService customerCreateService = new CustomerCreateService();

    // Helper method to safely trim strings
    private String safeTrim(String param) {
        return param != null ? param.trim() : "";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get parameters safely
        String accno = safeTrim(req.getParameter("accno"));
        String firstname = safeTrim(req.getParameter("fname"));
        String lastname = safeTrim(req.getParameter("lname"));
        String address = safeTrim(req.getParameter("address"));
        String mobileno = safeTrim(req.getParameter("mobileno"));

        // Basic validation
        if (accno.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || mobileno.isEmpty()) {
            req.setAttribute("error", "All fields are required. Please fill in all details.");
            req.getRequestDispatcher("newcustomer.jsp").forward(req, resp);
            return;
        }

        // Create customer object
        CustomerRegister customerRegister = new CustomerRegister(accno, firstname, lastname, address, mobileno);

        // Call service to register customer
        String result = customerCreateService.registerCustomer(customerRegister);

        // Set success or error message
        if (result.contains("✅")) {
            req.setAttribute("success", result);
        } else {
            req.setAttribute("error", result);
        }

        // Forward back to JSP
        req.getRequestDispatcher("newcustomer.jsp").forward(req, resp);
    }
}
