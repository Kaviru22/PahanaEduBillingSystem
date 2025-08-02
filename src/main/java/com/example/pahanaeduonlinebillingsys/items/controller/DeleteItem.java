package com.example.pahanaeduonlinebillingsys.items.controller;

import com.example.pahanaeduonlinebillingsys.customer.model.CustomerDelete;
import com.example.pahanaeduonlinebillingsys.customer.service.CustomerDeleteService;
import com.example.pahanaeduonlinebillingsys.items.model.ItemDelete;
import com.example.pahanaeduonlinebillingsys.items.service.ItemDeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    @WebServlet("/DeleteItem")
    public class DeleteItem extends HttpServlet {

        private final ItemDeleteService itemDeleteService = new ItemDeleteService();

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String itemno = req.getParameter("itemno");
            ItemDelete itemDelete = new ItemDelete(itemno);

            String result = itemDeleteService.deleteItem(itemDelete);
            req.setAttribute("message", result);
            req.getRequestDispatcher("DeleteItem.jsp").forward(req, resp);

        }
}
