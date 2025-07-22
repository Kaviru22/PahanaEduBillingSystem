package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCreateServiceTest {

    @Test
    void testInvalidEmail() {
        UserCreateService service = new UserCreateService();

        UserRegister user = new UserRegister("test", "Test", "User", "invalidemail", "pass123", "pass123");
        String result = service.registerUser(user);

        assertTrue(result.contains("Invalid email"), "Should fail with invalid email");
        System.out.println("Invalid Test Email Passed. Results :" +result);
    }

    @Test
    void testPasswordMismatch() {
        UserCreateService service = new UserCreateService();

        UserRegister user = new UserRegister("test", "Test", "User", "test@email.com", "pass123", "pass345");
        String result = service.registerUser(user);

        assertTrue(result.contains("do not match"), "Should fail with password mismatch");
        System.out.println("Password Mismatched Test Passed. Results :" +result);
    }

}

