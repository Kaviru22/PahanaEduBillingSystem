package com.example.pahanaeduonlinebillingsys.user.controller;

import com.example.pahanaeduonlinebillingsys.user.dao.UserLoginDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginUser extends HttpServlet {
    private UserLoginDAO userLoginDAO = new UserLoginDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();

        //Hardcoded Admin Check
        if (username.equals("admin") && password.equals("admin123")) {
            req.getSession().setAttribute("username", "admin");
            resp.sendRedirect("admin.jsp");
            return;
        }

        UserLogin userLogin = new UserLogin(username, password);
        UserLoginDAO userLoginDAO = new UserLoginDAO();

        if (userLoginDAO.validateUser(userLogin)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("user.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
