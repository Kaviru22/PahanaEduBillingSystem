package com.example.pahanaeduonlinebillingsys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?");
            ps.setString(1, username);

            int rows = ps.executeUpdate();
            conn.close();

            if (rows > 0) {
                req.setAttribute("message", "✅ User '" + username + "' deleted successfully.");
                req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "❌ User not found.");
            }

        } catch (Exception e) {
            req.setAttribute("message", "Error: " + e.getMessage());
        }

        req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);

    }
    }
