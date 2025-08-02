package com.example.pahanaeduonlinebillingsys.customer.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerService;
import com.example.pahanaeduonlinebillingsys.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/viewcustomer")
    public class ViewCustomer extends HttpServlet {
        private CustomerService customerService = new CustomerService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String accno = req.getParameter("customeraccno");

            CustomerRegister customerReg = customerService.getCustomerByAccno(accno);
            if (customerReg != null) {
                req.setAttribute("customer", customerReg);
            } else {
                req.setAttribute("message", "Customer not found.");
            }

            req.getRequestDispatcher("viewcustomer.jsp").forward(req, resp);
        }

    }

