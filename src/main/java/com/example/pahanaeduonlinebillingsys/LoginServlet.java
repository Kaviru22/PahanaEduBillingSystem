package com.example.pahanaeduonlinebillingsys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        LoginService loginService = new LoginService();

        if (loginService.validateUser(userLogin)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("user.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
