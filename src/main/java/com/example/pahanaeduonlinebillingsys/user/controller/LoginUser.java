package com.example.pahanaeduonlinebillingsys.user.controller;

import com.example.pahanaeduonlinebillingsys.user.dao.UserLoginDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginUser extends HttpServlet {
    private final UserLoginServer userLoginServer = new UserLoginServer();;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();

        String result = userLoginServer.login(username, password);

        //Hardcoded Admin Check
        if (username.equals("admin") && password.equals("admin123")) {
            req.getSession().setAttribute("username", "admin");
            resp.sendRedirect("admin.jsp");
            return;
        }

        if ("SUCCESS".equals(result)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("user.jsp");
        } else {
            req.setAttribute("error", result);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
