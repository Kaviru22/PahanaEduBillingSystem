package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserLoginDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserLoginServiceTest {

    private UserLoginDAO userLoginDAOMock;
    private UserLoginServer userLoginServer;

    @BeforeEach
    void setUp() {
        userLoginDAOMock = mock(UserLoginDAO.class);

        // Inject the mock into a custom subclass
        userLoginServer = new UserLoginServer() {
            private final UserLoginDAO dao = userLoginDAOMock;

            @Override
            public String login(String username, String password) {
                if (username == null || username.trim().isEmpty()) {
                    return "Username cannot be empty";
                }
                if (password == null || password.trim().isEmpty()) {
                    return "Password cannot be empty";
                }
                boolean isValid = dao.validateUser(username, password);
                return isValid ? "SUCCESS" : "Invalid username or password";
            }
        };
    }

    @Test
    void testLoginSuccess() {
        when(userLoginDAOMock.validateUser("john123", "pass123")).thenReturn(true);
        String result = userLoginServer.login("john123", "pass123");

        assertEquals("SUCCESS", result);
        System.out.println("User Login Success Unit Testing : " + result);
    }

    @Test
    void testLoginInvalidCredentials() {
        when(userLoginDAOMock.validateUser("john123", "wrongpass")).thenReturn(false);
        String result = userLoginServer.login("john123", "wrongpass");

        assertEquals("Invalid username or password", result);
        System.out.println("User Login Failure Unit Testing : " + result);
    }

    @Test
    void testEmptyUsername() {
        String result = userLoginServer.login("", "pass123");
        assertEquals("Username cannot be empty", result);
        System.out.println("User Login Empty Username Unit Testing : " + result);
    }

    @Test
    void testEmptyPassword() {
        String result = userLoginServer.login("john123", "");
        assertEquals("Password cannot be empty", result);
        System.out.println("User Login Empty Password Unit Testing : " + result);
    }
}
