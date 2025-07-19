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

        if ("admin".equals(username) && "admin123".equals(password)) {
            resp.sendRedirect("admin.jsp");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String selectquery = "SELECT * FROM users WHERE username=? and password=?";
            PreparedStatement ps = conn.prepareStatement(selectquery);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resp.sendRedirect("user.jsp");
            } else {
                resp.sendRedirect("login.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("login.jsp?error=2");
        }
    }
}
