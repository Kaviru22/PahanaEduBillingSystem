package com.example.pahanaeduonlinebillingsys.user.controller;

import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import com.example.pahanaeduonlinebillingsys.user.service.UserDeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

    private final UserDeleteService userDeleteService = new UserDeleteService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserDelete userDelete = new UserDelete(username);

        String result = userDeleteService.deleteUser(userDelete);
        req.setAttribute("message", result);
        req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);

    }

    }
