package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import com.example.pahanaeduonlinebillingsys.user.service.UserCreateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserCreationIntegrateTest {

    private Connection connection;
    private UserCreateService userCreateService;

    @BeforeEach
    void setUp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/pahanaEduOnlineShop";
        String user = "postgres";
        String password = "kaviru123";

        connection = DriverManager.getConnection(url, user, password);
        userCreateService = new UserCreateService();

    }

    @Test
    void testcreateUser() throws Exception {

        UserRegister userRegister = new UserRegister("testuser1", "Test", "Integration",
                "integ@example.com", "pass123", "pass123");

        String result = userCreateService.registerUser(userRegister);
        System.out.println("Result from registerUser(): " + result);
        assertTrue(result.contains("success"), "User creation should succeed");
        System.out.println("Integration Test Passed: " + result);

        PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM users WHERE username = ?");
        stmt.setString(1, "testuser1");

        ResultSet rs = stmt.executeQuery();
        assertEquals(rs.next(), "❌ User already exists", "User should exist in database");

    }

    /*@AfterEach
    void tearDown() throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE username = ?");
        stmt.setString(1, "test_integration_user");
        stmt.executeUpdate();
        connection.close();
    }  */
}
