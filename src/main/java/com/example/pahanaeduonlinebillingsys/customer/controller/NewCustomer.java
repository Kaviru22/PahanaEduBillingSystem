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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int accno = Integer.parseInt(req.getParameter("accnumber").trim());
        String firstname = req.getParameter("firstname").trim();
        String lastname = req.getParameter("lastname").trim();
        String address = req.getParameter("address").trim();
        String mobileno = req.getParameter("mobileno").trim();


        CustomerRegister customerRegister = new CustomerRegister(accno, firstname, lastname, address, mobileno);

        String result = customerCreateService.registerCustomer(customerRegister);

        if (result.contains("✅")) {
            req.setAttribute("success", result);
        } else {
            req.setAttribute("error", result);
        }

        req.getRequestDispatcher("newcustomer.jsp").forward(req, resp);
    }

}

