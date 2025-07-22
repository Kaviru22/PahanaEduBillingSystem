package com.example.pahanaeduonlinebillingsys.user.controller;

import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import com.example.pahanaeduonlinebillingsys.user.service.UserCreateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newuser")
public class NewUser extends HttpServlet {
    private final UserCreateService userService = new UserCreateService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username").trim();
        String firstname = req.getParameter("firstname").trim();
        String lastname = req.getParameter("lastname").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String confirmPassword = req.getParameter("confirmPassword").trim();

        UserRegister userRegister = new UserRegister(username, firstname, lastname, email, password, confirmPassword);

        String result = userService.registerUser(userRegister);

        if (result.contains("✅")) {
            req.setAttribute("success", result);
        } else {
            req.setAttribute("error", result);
        }

        req.getRequestDispatcher("newuser.jsp").forward(req, resp);
    }
}
