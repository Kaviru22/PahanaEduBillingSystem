package com.example.pahanaeduonlinebillingsys.user.controller;

import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        User user = userService.getUserByUsername(username);
        if (user != null) {
            req.setAttribute("user", user);
        } else {
            req.setAttribute("message", "User not found.");
        }

        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String originalUsername = req.getParameter("originalUsername");
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User newUser = new User(username, firstname, lastname, email, password);

        String message = userService.updateUser(originalUsername, newUser);
        req.setAttribute("message", message);

        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }
}

