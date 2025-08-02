package com.example.pahanaeduonlinebillingsys.customer.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerUpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/UpdateCustomer")
    public class UpdateCustomer extends HttpServlet {
        private CustomerUpdateService customerUpdateService = new CustomerUpdateService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String accno = req.getParameter("accno");

            CustomerRegister customerRegister = customerUpdateService.getCustomerByAccNo(accno);
            if (customerRegister != null) {
                req.setAttribute("customer", customerRegister);
            } else {
                req.setAttribute("message", "Customer not found.");
            }

            req.getRequestDispatcher("UpdateCustomer.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String originalAccno = req.getParameter("originalAccno");
            String accno = req.getParameter("accno");
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String address = req.getParameter("address");
            String mobileno = req.getParameter("mobileno");

            CustomerRegister updatedCustomer = new CustomerRegister(accno, fname, lname, address, mobileno);

            String message = customerUpdateService.updateCustomer(originalAccno, updatedCustomer);
            req.setAttribute("message", message);
            req.setAttribute("customer", updatedCustomer);

            req.getRequestDispatcher("UpdateCustomer.jsp").forward(req, resp);
        }
    }
