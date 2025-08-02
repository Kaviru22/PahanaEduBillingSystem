package com.example.pahanaeduonlinebillingsys.items.controller;

import com.example.pahanaeduonlinebillingsys.items.model.ItemAdd;
import com.example.pahanaeduonlinebillingsys.items.service.ItemAddService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/additems")
    public class NewItem extends HttpServlet {
        private final ItemAddService itemAddService = new ItemAddService();

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String itemno = req.getParameter("itemno");
            String itemname = req.getParameter("itemname");
            String quantity = req.getParameter("quanty");
            String unitprice = req.getParameter("unitprice");


            ItemAdd itemAdd = new ItemAdd(itemno, itemname, quantity, unitprice);

            String result = itemAddService.AddItems(itemAdd);

            if (result.contains("✅")) {
                req.setAttribute("success", result);
            } else {
                req.setAttribute("error", result);
            }

            req.getRequestDispatcher("additems.jsp").forward(req, resp);
        }
}
