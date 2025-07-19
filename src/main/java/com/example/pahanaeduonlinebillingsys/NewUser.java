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

@WebServlet("/newuser")
public class NewUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username").trim();
        String firstname = req.getParameter("firstname").trim();
        String lastname = req.getParameter("lastname").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String confirmPassword = req.getParameter("confirmPassword").trim();

        if (!password.equals(confirmPassword)) {
            req.setAttribute("error", "❌ Passwords do not match!");
            req.getRequestDispatcher("newuser.jsp").forward(req, resp);
            return;
        }


        try {
            Connection conn = DBConnection.getConnection();

            // Check if username or email already exists
            String checkQuery = "SELECT * FROM users WHERE username = ? OR email = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                req.setAttribute("error", "❌ User already exists!");
                req.getRequestDispatcher("newuser.jsp").forward(req, resp);
                return;
            }

            String insertquery = "INSERT INTO users (username, firstname, lastname, email, password) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertquery);
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, email);
            ps.setString(5, password);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                req.setAttribute("success", "✅ User created successfully!");
                req.getRequestDispatcher("newuser.jsp").forward(req, resp);
                resp.sendRedirect("admin.jsp");
                return;

            } else {
                req.setAttribute("error", "❌ Failed to create user!");
            }

            checkStmt.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error: " + e.getMessage());
        }
    }
}
