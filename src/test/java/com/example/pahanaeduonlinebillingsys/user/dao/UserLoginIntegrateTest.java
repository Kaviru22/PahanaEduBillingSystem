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

    @Test
    void testLoginWithValidCredentials() {
        UserLoginServer server = new UserLoginServer();

        // Must already exist in DB
        String result = server.login("user3", "1234567");

        assertEquals("SUCCESS", result);
        System.out.println("User Login Success Integration Testing : " + result);
    }

    @Test
    void testLoginWithInvalidCredentials() {
        UserLoginServer server = new UserLoginServer();

        String result = server.login("wronguser", "wrongpass");

        assertEquals("Invalid username or password", result);
        System.out.println("User Login Invalid Integration Testing : " + result);
    }
}
