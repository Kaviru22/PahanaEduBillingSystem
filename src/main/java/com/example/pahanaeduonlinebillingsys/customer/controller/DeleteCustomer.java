package com.example.pahanaeduonlinebillingsys.customer.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerDeleteService;
import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import com.example.pahanaeduonlinebillingsys.user.service.UserDeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    @WebServlet("/DeleteCustomer")
    public class DeleteCustomer extends HttpServlet {

        private final CustomerDeleteService customerDeleteService = new CustomerDeleteService();

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String accno = req.getParameter("accno");
            CustomerDelete customerDelete = new CustomerDelete(accno);

            String result = customerDeleteService.deleteCustomer(customerDelete);
            req.setAttribute("message", result);
            req.getRequestDispatcher("DeleteCustomer.jsp").forward(req, resp);

        }
}
