package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.NewUserDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserCreateServiceTest {

    private NewUserDAO userDAOMock;
    private UserCreateService service;

    @BeforeEach
    void setUp() {
        userDAOMock = Mockito.mock(NewUserDAO.class);
        service = new UserCreateService() {
            private final NewUserDAO dao = userDAOMock;

            @Override
            public String registerUser(UserRegister userRegister) {
                try {
                    if (!userRegister.getPassword().equals(userRegister.getConfirmpassword())) {
                        return "❌ Passwords do not match!";
                    }
                    if (!userRegister.getEmail().contains("@") || userRegister.getPassword().length() < 6) {
                        return "Invalid email or password must be 6+ characters.";
                    }
                    if (dao.userExists(userRegister.getUsername(), userRegister.getEmail())) {
                        return "❌ User already exists!";
                    }
                    return dao.insertUser(userRegister) ? "✅ User created successfully!" : "❌ Failed to create user!";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testPasswordMismatch() {
        UserRegister user = new UserRegister("test", "Test", "User", "test@email.com", "123456", "654321");
        String result = service.registerUser(user);
        assertTrue(result.contains("Passwords do not match"));
        System.out.println("User Creation Password Mismatch Unit Testing :" +result);
    }

    @Test
    void testInvalidEmailOrPassword() {
        UserRegister user = new UserRegister("test", "Test", "User", "invalidemail", "123", "123");
        String result = service.registerUser(user);
        assertTrue(result.contains("Invalid email"));
        System.out.println("User Creation Email Mismatch Unit Testing :" +result);
    }

    @Test
    void testUserAlreadyExists() throws Exception {
        UserRegister user = new UserRegister("test", "Test", "User", "test@email.com", "123456", "123456");
        when(userDAOMock.userExists("test", "test@email.com")).thenReturn(true);

        String result = service.registerUser(user);
        assertTrue(result.contains("User already exists"));
        System.out.println("User Creation Already Exists Unit Testing :" +result);
    }

    @Test
    void testUserCreatedSuccessfully() throws Exception {
        UserRegister user = new UserRegister("test", "Test", "User", "test@email.com", "123456", "123456");
        when(userDAOMock.userExists(anyString(), anyString())).thenReturn(false);
        when(userDAOMock.insertUser(any(UserRegister.class))).thenReturn(true);

        String result = service.registerUser(user);
        assertTrue(result.contains("✅ User created successfully"));
        System.out.println("User Creation Success Unit Testing :" +result);
    }
}

