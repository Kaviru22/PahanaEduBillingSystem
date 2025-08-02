package com.example.pahanaeduonlinebillingsys.items.controller;

import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.items.service.ItemUpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/UpdateItem")
    public class UpdateItem extends HttpServlet {
        private ItemUpdateService itemUpdateService = new ItemUpdateService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String itemno = req.getParameter("itemno");

            ItemAdd itemAdd = itemUpdateService.getItemByItemNo(itemno);
            if (itemAdd != null) {
                req.setAttribute("item", itemAdd);
            } else {
                req.setAttribute("message", "Item not found.");
            }

            req.getRequestDispatcher("UpdateItem.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String originalItemno = req.getParameter("originalItemno");
            String itemno = req.getParameter("itemno");
            String itemname = req.getParameter("itemname");
            String quanty = req.getParameter("quanty");
            String unitprice = req.getParameter("unitprice");

            ItemAdd itemAdd = new ItemAdd(itemno, itemname, quanty, unitprice);

            String message = itemUpdateService.updateItem(originalItemno, itemAdd);
            req.setAttribute("message", message);
            req.setAttribute("item", itemAdd);

            req.getRequestDispatcher("UpdateItem.jsp").forward(req, resp);
        }
}
