package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import com.example.pahanaeduonlinebillingsys.user.service.UserCreateService;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserLoginIntegrateTest {

    private Connection connections;
    private UserLoginServer userLoginServer;

    @BeforeEach
    void setUp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/pahanaEduOnlineShop";
        String user = "postgres";
        String password = "kaviru123";

        connections = DriverManager.getConnection(url, user, password);
        userLoginServer = new UserLoginServer();

        // Insert a known test user for integration tests
        PreparedStatement stmt = connections.prepareStatement(
                "INSERT INTO users (username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?) ON CONFLICT (username) DO NOTHING"
        );
        stmt.setString(1, "testuser1");
        stmt.setString(2, "Test");
        stmt.setString(3, "User");
        stmt.setString(4, "test1test@example.com");
        stmt.setString(5, "pass123");
        stmt.executeUpdate();

    }

    @Test
    void testLoginSuccess() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("test", "pass123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertSame("Login Success", "Login Success", "User should login successfully");
        System.out.println("Test Login Passed :" + result);
    }

    @Test
    void testEmptyUserName() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("","user123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Username cannot be empty", result);
        System.out.println("Empty UserName Login Test Passed :" +result);

    }

    @Test
    void testEmptyPassword() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("user","");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Password cannot be empty", result);
        System.out.println("Empty Password Login Test Passed :" +result);

    }

    @Test
    void testInvalidUserName() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("wrong123","pass123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Invalid username or password", result);
        System.out.println("Invalid UserName Login Test Passed :" +result);

    }

    @Test
    void testInvalidPassword() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("testuser1","testing");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Invalid username or password", result, "Should fail with Invalid Password");
        System.out.println("Invalid Password Login Test Passed :" +result);

    }

}
