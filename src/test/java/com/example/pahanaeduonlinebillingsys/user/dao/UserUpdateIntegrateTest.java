package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;
import com.example.pahanaeduonlinebillingsys.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserUpdateIntegrateTest {

    private Connection connection;
    private UserService userService;
    private UserLoginServer userLoginServer;

    @BeforeEach
    void setUp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/pahanaEduOnlineShop";
        String user = "postgres";
        String password = "kaviru123";

        connection = DriverManager.getConnection(url, user, password);
        userService = new UserService();
        userLoginServer = new UserLoginServer();

        // Ensure the user exists before updating
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO users (username, firstname, lastname, email, password) " +
                        "VALUES (?, ?, ?, ?, ?) ON CONFLICT (username) DO UPDATE SET " +
                        "firstname = EXCLUDED.firstname, lastname = EXCLUDED.lastname, " +
                        "email = EXCLUDED.email, password = EXCLUDED.password"
        );
        stmt.setString(1, "testuser1");
        stmt.setString(2, "Initial");
        stmt.setString(3, "User");
        stmt.setString(4, "initial@example.com");
        stmt.setString(5, "pass123");
        stmt.executeUpdate();
    }

    @Test
    void testUpdateUserAndVerify() throws SQLException {
        // ✅ Step 1: Update the user using raw SQL
        PreparedStatement updateStmt = connection.prepareStatement(
                "UPDATE users SET firstname = ?, lastname = ?, email = ? WHERE username = ?"
        );
        updateStmt.setString(1, "Updated");
        updateStmt.setString(2, "Name");
        updateStmt.setString(3, "updated@example.com");
        updateStmt.setString(4, "testuser1");

        int rowsAffected = updateStmt.executeUpdate();
        assertEquals(1, rowsAffected, "One row should be updated");

        // ✅ Step 2: Fetch and verify the updated user
        PreparedStatement selectStmt = connection.prepareStatement(
                "SELECT firstname, lastname, email FROM users WHERE username = ?"
        );
        selectStmt.setString(1, "testuser1");

        ResultSet rs = selectStmt.executeQuery();
        assertTrue(rs.next(), "User should exist");

        assertEquals("Updated", rs.getString("firstname"));
        assertEquals("Name", rs.getString("lastname"));
        assertEquals("updated@example.com", rs.getString("email"));

        System.out.println("✅ User Update Test Passed: User info updated successfully.");
    }

    @Test
    void testLoginSuccess() {
        UserLogin userLogin = new UserLogin("testuser1", "pass123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("SUCCESS", result, "User should login successfully");
        System.out.println("✅ Login Test Passed: " + result);
    }

   /* @AfterEach
    void tearDown() throws SQLException {
        // Cleanup test user
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE username = ?");
        stmt.setString(1, "testuser1");
        stmt.executeUpdate();

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }  */

}
