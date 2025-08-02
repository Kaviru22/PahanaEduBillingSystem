package com.example.pahanaeduonlinebillingsys.items.controller;

import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.items.service.ItemViewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/ViewItem")
    public class ViewItem extends HttpServlet {
        private ItemViewService itemViewService = new ItemViewService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String itemno = req.getParameter("itemno");

            ItemAdd itemAdd = itemViewService.getItemByItemNo(itemno);
            if (itemAdd != null) {
                req.setAttribute("item", itemAdd);
            } else {
                req.setAttribute("message", "Item not found.");
            }

            req.getRequestDispatcher("ViewItem.jsp").forward(req, resp);
        }
}
