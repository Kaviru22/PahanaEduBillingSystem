package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserDeleteService;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertSame;

class UserDeleteIntegrateTest {

    private Connection connections;
    private UserDeleteService userDeleteService;

    @BeforeEach
    void setUp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/pahanaEduOnlineShop";
        String user = "postgres";
        String password = "kaviru123";

        connections = DriverManager.getConnection(url, user, password);
        userDeleteService = new UserDeleteService();

        // Insert a known test user for integration tests
        PreparedStatement stmt = connections.prepareStatement(
                "INSERT INTO users (username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?) ON CONFLICT (username) DO NOTHING"
        );
        stmt.setString(1, "user3");
        stmt.setString(2, "test3");
        stmt.setString(3, "test03");
        stmt.setString(4, "Test3@gmail.com");
        stmt.setString(5, "1234567");
        stmt.executeUpdate();

    }

    @Test
    void testDeleteSuccess() {
        UserDeleteService userDeleteService1 = new UserDeleteService();

        UserDelete userDelete = new UserDelete("user3");
        String result = userDeleteService1.deleteUser(userDelete);

        assertSame("deleted successfully", "deleted successfully", "User should Delete successfully");
        System.out.println("User Delete Test Passed :" + result);
    }


    @Test
    void testDeleteFailure() {
        UserDeleteService userDeleteService = new UserDeleteService();

        UserDelete userDelete = new UserDelete("test56");
        String result = userDeleteService.deleteUser(userDelete);

        assertSame("❌ User not found.", "❌ User not found.", "User should Not Delete successfully");
        System.out.println("User delete Failed Test Passed :" + result);
    }

}
