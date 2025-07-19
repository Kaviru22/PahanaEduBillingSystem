package com.example.pahanaeduonlinebillingsys;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                req.setAttribute("user", user);
            } else {
                req.setAttribute("message", "User not found.");
            }

            rs.close(); ps.close(); conn.close();

        } catch (Exception e) {
            req.setAttribute("message", "Error: " + e.getMessage());
        }

        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String originalUsername = req.getParameter("originalUsername");
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Email & password validation using Java (basic)
        if (!email.contains("@") || password.length() < 6) {
            req.setAttribute("message", "Invalid email or password must be 6+ characters.");
            req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String updateSQL = "UPDATE users SET username=?, firstname=?, lastname=?, email=?, password=? WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, originalUsername);

            int updated = ps.executeUpdate();

            if (updated > 0) {
                req.setAttribute("message", "User updated successfully.");
            } else {
                req.setAttribute("message", "Update failed.");
            }

            ps.close(); conn.close();

        } catch (Exception e) {
            req.setAttribute("message", "Error: " + e.getMessage());
        }

        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }
}

