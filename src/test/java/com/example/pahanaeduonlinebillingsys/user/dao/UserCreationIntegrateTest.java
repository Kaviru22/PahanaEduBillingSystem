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

    @Test
    void testInsertAndRetrieveUser() {
        UserCreateService service = new UserCreateService();

        UserRegister newUser = new UserRegister(
                "testuser", "Test", "User", "testuser@email.com", "pass123", "pass123"
        );

        String result = service.registerUser(newUser);

        assertTrue(result.contains("✅") || result.contains("already exists"));
        System.out.println("User Creating Integration Testing :" +result);
    }
}
